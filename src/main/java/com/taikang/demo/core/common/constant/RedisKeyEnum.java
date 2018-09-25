package com.taikang.demo.core.common.constant;

/**
 * 存储在redis中的键
 *
 * @author Eunice
 * @date 2018/9/15
 */
public enum RedisKeyEnum {
    观影券小红点("CUSTOMER_REQUEST:RED_POINT:WEBCAST:%s"),    //%s---managerNo
    WebSocket连接数("WEBSOCKET_CONNECT_COUNT:%s"); //%s---连接类型, 如: pushMsg


    private String RedisKeyFormat;

    RedisKeyEnum(String redisKeyFormat) {
        RedisKeyFormat = redisKeyFormat;
    }

    public String getRedisKeyFormat() {
        return RedisKeyFormat;
    }

}
