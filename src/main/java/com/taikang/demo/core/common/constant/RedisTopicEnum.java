package com.taikang.demo.core.common.constant;

/**
 * redis消息发布订阅的topic
 *
 * @author Eunice
 * @date 2018/9/18
 */
public enum RedisTopicEnum {
    小红点("redPoint");

    private String topic;

    RedisTopicEnum(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }
}
