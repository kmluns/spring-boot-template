package com.uns.template.config;

import com.uns.template.config.mongo.InheritanceAwareMongoRepositoryFactoryBean;
import com.uns.template.config.mongo.InheritanceAwareSimpleMongoRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * created by kmluns
 **/
@Configuration
@EnableMongoRepositories(
        repositoryBaseClass = InheritanceAwareSimpleMongoRepository.class,
        repositoryFactoryBeanClass = InheritanceAwareMongoRepositoryFactoryBean.class,
        basePackages = "com.uns.template.repository")
public class MongoConfig {

}