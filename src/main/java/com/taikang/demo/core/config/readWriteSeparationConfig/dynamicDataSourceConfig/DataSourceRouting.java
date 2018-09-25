package com.taikang.demo.core.config.readWriteSeparationConfig.dynamicDataSourceConfig;

import com.taikang.demo.core.common.constant.DataSourceType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态配置数据源
 *
 * @author Eunice
 * @date 2018/8/9
 */
@Configuration
public class DataSourceRouting {

    @Value("${spring.readWriteFlag}")
    private boolean flag;   //是否使用读写分离

    @Bean("routingDataSource")
    public AbstractRoutingDataSource routingDataSource(@Qualifier("readDataSource") DataSource readDataSource, @Qualifier("writeDataSource") DataSource writeDataSource){
        DynamicDataSource dynamicDataSource = new DynamicDataSource(flag);
        Map<Object, Object> map = new HashMap<>(2);
        map.put(DataSourceType.read.getType(), readDataSource);
        map.put(DataSourceType.write.getType(), writeDataSource);

        dynamicDataSource.setTargetDataSources(map);
        dynamicDataSource.setDefaultTargetDataSource(writeDataSource);
        return dynamicDataSource;
    }

}
