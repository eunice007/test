package com.taikang.demo.core.config.readWriteSeparationConfig.dynamicDataSourceConfig;

import com.taikang.demo.core.common.constant.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author Eunice
 * @date 2018/8/9
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    private boolean flag;   //是否使用读写分离

    public DynamicDataSource(boolean flag) {
        this.flag = flag;
    }

    /**
     * 当前使用的数据库
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DynamicDataSourceHolder.getDataSource();
        if (flag){
            //默认使用写库
            if (null==dataSource || "".equals(dataSource)){
                dataSource = DataSourceType.write.getType();
            }
            log.info("dataSource: {}", dataSource);
            return dataSource;
        }else{
            log.info("dataSources: {}", DataSourceType.write.getType());
            return DataSourceType.write.getType();
        }
    }
}
