package hive.metastore.sdl;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.api.MetaException;

@Slf4j
public class HMSHandler extends org.apache.hadoop.hive.metastore.HiveMetaStore.HMSHandler {
    public HMSHandler(String name) throws MetaException {
        super(name);
    }

    public HMSHandler(String name, HiveConf conf) throws MetaException {
        super(name, conf);
    }

    public HMSHandler(String name, HiveConf conf, boolean init) throws MetaException {
        super(name, conf, init);
    }
}