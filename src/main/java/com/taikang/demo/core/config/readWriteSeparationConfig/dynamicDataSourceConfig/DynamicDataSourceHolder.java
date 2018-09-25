package com.taikang.demo.core.config.readWriteSeparationConfig.dynamicDataSourceConfig;

/**
 * 绑定当前线程和数据源
 *
 * @author Eunice
 * @date 2018/8/9
 */
public class DynamicDataSourceHolder {
    private static final ThreadLocal<String> DATA_SOURCE = new ThreadLocal<>();

    public static String getDataSource() {
        return DATA_SOURCE.get();
    }

    public static void setDataSource(String dataSource){
        DATA_SOURCE.set(dataSource);
    }

    public static void clearDataSource(String dataSource){
        DATA_SOURCE.remove();
    }
}
