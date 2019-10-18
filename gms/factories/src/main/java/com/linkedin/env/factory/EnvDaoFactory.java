package com.linkedin.env.factory;

import com.linkedin.common.urn.DatasetUrn;
import com.linkedin.common.urn.FabricUrn;
import com.linkedin.metadata.aspect.FabricAspect;
import com.linkedin.metadata.dao.EbeanLocalDAO;
import com.linkedin.metadata.dao.producer.KafkaMetadataEventProducer;
import com.linkedin.metadata.dao.producer.KafkaProducerCallback;
import com.linkedin.metadata.snapshot.DatasetSnapshot;
import com.linkedin.metadata.snapshot.FabricSnapshot;
import io.ebean.config.ServerConfig;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class EnvDaoFactory {
    @Autowired
    ApplicationContext applicationContext;

    @Bean(name = "envDao")
    @DependsOn({"gmsEbeanServiceConfig", "kafkaEventProducer"})
    protected EbeanLocalDAO<FabricAspect, FabricUrn> createInstance() {
        KafkaMetadataEventProducer<FabricSnapshot, FabricAspect, FabricUrn> producer =
                new KafkaMetadataEventProducer<>(FabricSnapshot.class,
                        FabricAspect.class,
                        applicationContext.getBean(Producer.class),
                        new KafkaProducerCallback());

        return new EbeanLocalDAO<>(FabricAspect.class, producer, applicationContext.getBean(ServerConfig.class));
    }
}
