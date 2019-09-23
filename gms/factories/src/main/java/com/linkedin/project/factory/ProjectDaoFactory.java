package com.linkedin.project.factory;

import com.linkedin.common.urn.ProjectUrn;
import com.linkedin.metadata.aspect.ProjectAspect;
import com.linkedin.metadata.dao.EbeanLocalDAO;
import com.linkedin.metadata.dao.producer.KafkaMetadataEventProducer;
import com.linkedin.metadata.snapshot.ProjectSnapshot;
import io.ebean.config.ServerConfig;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.Nonnull;

@Configuration
public class ProjectDaoFactory {
    @Autowired
    ApplicationContext applicationContext;

    @Bean(name = "projectDao")
    @DependsOn({"gmsEbeanServiceConfig"})
    @Nonnull
    protected EbeanLocalDAO createInstance() {
        KafkaMetadataEventProducer<ProjectSnapshot, ProjectAspect, ProjectUrn> producer =
                new KafkaMetadataEventProducer(ProjectSnapshot.class, ProjectAspect.class,
                        applicationContext.getBean(Producer.class));
        return new EbeanLocalDAO<>(ProjectAspect.class, producer, applicationContext.getBean(ServerConfig.class));
    }
}