package com.taikang.demo.core.config.readWriteSeparationConfig;

import com.taikang.demo.core.common.constant.DataSourceType;
import com.taikang.demo.core.config.readWriteSeparationConfig.dynamicDataSourceConfig.DynamicDataSourceHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

/**
 * @author Eunice
 * @date 2018/8/9
 */
@Slf4j
public class MyJpaTransactionManager extends JpaTransactionManager {
    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) {
        //设置当前操作是读操作还是写操作
        boolean readOnly = definition.isReadOnly();
        if (!readOnly){
            DynamicDataSourceHolder.setDataSource(DataSourceType.write.getType());
        }
        if(log.isDebugEnabled()){
            log.info("transaction-readOnly?: {}", readOnly);
        }
        super.doBegin(transaction, definition);
    }

    @Override
    protected void doCommit(DefaultTransactionStatus status) {
        //打印操作的数据源
        String dataSource = DynamicDataSourceHolder.getDataSource();
        if (log.isDebugEnabled()){
            log.info("dataSource: {}", dataSource);
        }
        super.doCommit(status);
    }
}
