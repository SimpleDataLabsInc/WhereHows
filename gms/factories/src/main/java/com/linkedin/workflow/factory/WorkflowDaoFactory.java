package com.linkedin.workflow.factory;

import com.linkedin.common.urn.WorkflowUrn;
import com.linkedin.metadata.aspect.WorkflowAspect;
import com.linkedin.metadata.dao.EbeanLocalDAO;
import com.linkedin.metadata.dao.producer.KafkaMetadataEventProducer;
import com.linkedin.metadata.snapshot.WorkflowSnapshot;
import io.ebean.config.ServerConfig;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.Nonnull;

@Configuration
public class WorkflowDaoFactory {
    @Autowired
    ApplicationContext applicationContext;

    @Bean(name = "workflowDao")
    @DependsOn({"gmsEbeanServiceConfig"})
    @Nonnull
    protected EbeanLocalDAO createInstance() {
        KafkaMetadataEventProducer<WorkflowSnapshot, WorkflowAspect, WorkflowUrn> producer =
                new KafkaMetadataEventProducer(WorkflowSnapshot.class, WorkflowAspect.class,
                        applicationContext.getBean(Producer.class));
        return new EbeanLocalDAO<>(WorkflowAspect.class, producer, applicationContext.getBean(ServerConfig.class));
    }
}