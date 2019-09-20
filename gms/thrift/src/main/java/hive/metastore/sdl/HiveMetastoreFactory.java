package hive.metastore.sdl;

import com.linkedin.metadata.dao.BaseLocalDAO;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hive.metastore.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@Slf4j
public class HiveMetastoreFactory {
    @Autowired
    ApplicationContext applicationContext;


    @Bean(name = "hiveMetastore")
    @DependsOn({"datasetDao", "kafkaEventProducer"})
    protected ThriftHiveMetastore.Iface createInstance() {
        return new HiveMetastoreImpl(applicationContext.getBean("datasetDao", BaseLocalDAO.class));
    }
}