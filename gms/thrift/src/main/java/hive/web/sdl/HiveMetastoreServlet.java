package hive.web.sdl;

import org.apache.hadoop.hive.metastore.api.ThriftHiveMetastore.Iface;
import org.apache.hadoop.hive.metastore.api.ThriftHiveMetastore.Processor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HiveMetastoreServlet extends HttpServlet {

    private static final long serialVersionUID = -8777659712204723236L;
    private ThriftDelegateServlet thriftServlet;

    @Override
    public void init() throws ServletException {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        Iface serviceHandler = webApplicationContext .getBean("hiveMetastore", Iface.class);
        Processor<Iface> processor = new Processor<Iface>(serviceHandler);
        thriftServlet = new ThriftDelegateServlet(processor, new TBinaryProtocol.Factory());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (thriftServlet == null) {
            init();
        }
        thriftServlet.doPost(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }

}
