package hive.web.sdl;

import com.linkedin.common.urn.FabricUrn;
import com.linkedin.metadata.aspect.FabricAspect;
import com.linkedin.metadata.dao.EbeanLocalDAO;
import hive.metastore.sdl.HMSHandler;
import hive.metastore.sdl.HiveMetastore;
import io.ebean.config.ServerConfig;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.ThriftHiveMetastore.Iface;
import org.apache.hadoop.hive.metastore.api.ThriftHiveMetastore.Processor;
import org.apache.thrift.protocol.TJSONProtocol;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class HiveMetastoreServlet extends HttpServlet {
    private static Map<String, ThriftDelegateServlet> SERVLETS = new HashMap<>();
    private final static Object lock = new Object();

    private static final long serialVersionUID = -8777659712204723236L;
    private WebApplicationContext context;
    private EbeanLocalDAO<FabricAspect, FabricUrn> fabricDao;
    private ServerConfig config;

    @Override
    public void init() throws ServletException {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        fabricDao = context.getBean("envDao", EbeanLocalDAO.class);
        config = context.getBean("gmsEbeanServiceConfig", ServerConfig.class);
    }

    private String getKey(HttpServletRequest req) {
        if (req.getPathInfo().startsWith("/"))
            return req.getPathInfo().substring(1);//.split("/");
        else
            throw new RuntimeException(String.format("Invalid req: %s", req.getPathInfo()));
    }

    private ThriftDelegateServlet createServlet(HttpServletRequest req) {
        val key = getKey(req);
        val path = req.getPathInfo();
        log.info("{}, {}", key, path);
        if (SERVLETS.get(key) == null) {
            synchronized (lock) {
                if (SERVLETS.get(key) == null) {
                    try {
                        Iface thriftHandler = new HMSHandler(key, getHiveConf(key, path));
                        val processor = new Processor<>(thriftHandler);
                        ThriftDelegateServlet servlet = new ThriftDelegateServlet(processor, new TJSONProtocol.Factory());
                        SERVLETS.put(key, servlet);
                    } catch (MetaException | URISyntaxException e) {
                        log.error(String.format("Cannot create Thrift Handler, %s", path), e);
                    }
                }
            }
        }
        return SERVLETS.get(key);
    }

    private HiveConf getHiveConf(String key, String path) throws URISyntaxException {
        Optional<HiveMetastore> datasetAspect = fabricDao.get(hive.metastore.sdl.HiveMetastore.class, new FabricUrn(key));
        val iterator = datasetAspect.get().getHiveConf().iterator();
        HiveConf conf = new HiveConf();
        while(iterator.hasNext()) {
            val n = iterator.next();
            conf.set(n.getKey(), n.getValue());
        }
        conf.setVar(HiveConf.ConfVars.METASTORE_CONNECTION_DRIVER, config.getDataSourceConfig().getDriver());
        conf.setVar(HiveConf.ConfVars.METASTORE_CONNECTION_USER_NAME, config.getDataSourceConfig().getUsername());
        conf.set("javax.jdo.option.ConnectionPassword", config.getDataSourceConfig().getPassword());
        return conf;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (fabricDao == null) {
            init();
        }
        createServlet(req).doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (fabricDao == null) {
            init();
        }
        createServlet(req).doGet(req, resp);
    }
}
