package com.taikang.demo.core.config.readWriteSeparationConfig;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author Eunice
 * @date 2018/8/9
 */
@Configuration
@EnableJpaRepositories(value = "com.taikang.demo.*.repository")
public class JpaConfig {
    @Resource
    private JpaProperties jpaProperties;

    @Resource(name = "routingDataSource")
    private DataSource dataSource;

    @Bean(name = "entityManagerFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder factoryBuilder) {
        return factoryBuilder.dataSource(dataSource).packages("com.taikang.demo.*.repository.entity").properties(jpaProperties.getProperties())
                //.mappingResources(this.getMappingResources()).jta(this.isJta())
                .build();
    }

    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory(EntityManagerFactoryBuilder factoryBuilder) {
        return this.entityManagerFactoryBean(factoryBuilder).getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder factoryBuilder) {
        MyJpaTransactionManager myJpaTransactionManager = new MyJpaTransactionManager();
        myJpaTransactionManager.setEntityManagerFactory(this.entityManagerFactory(factoryBuilder));

        return myJpaTransactionManager;
    }


}
