package com.taikang.demo.core.config.readWriteSeparationConfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 配置读写数据源
 *
 * @author Eunice
 * @date 2018/8/9
 */
@Configuration
public class LoadDataSource {

    @Primary
    @Bean(name = "writeDataSource")
    @ConfigurationProperties(prefix = "spring.data-source")
    public DataSource writeDataSource(){
        return new DruidDataSource();
    }

    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "spring.read-data-source")
    public DataSource readDataSource(){
        return new DruidDataSource();
    }
}
