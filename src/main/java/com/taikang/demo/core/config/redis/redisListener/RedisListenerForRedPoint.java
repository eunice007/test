package com.taikang.demo.core.config.redis.redisListener;

import com.alibaba.fastjson.JSONObject;
import com.taikang.demo.core.common.constant.RedisTopicEnum;
import com.taikang.demo.core.config.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import javax.annotation.Resource;

/**
 * @author Eunice
 * @date 2018/9/18
 */
@Slf4j
@Configuration
public class RedisListenerForRedPoint {
    @Resource
    private RedisMessageListenerContainer redisMessageListenerContainer;

    @Resource
    private WebSocketServer webSocketServer;

    @Bean
    public RedisMessageListenerContainer forRedPoint(){
        redisMessageListenerContainer.addMessageListener((message, pattern) -> {
            String msg = new String(message.getBody());
            log.info("监听器forRedPoint接收到消息: {}", msg);
            JSONObject jsonMsg = JSONObject.parseObject(msg);
            webSocketServer.sendMessage(jsonMsg.getString("managerNo"), jsonMsg.getString("message"));
        }, new PatternTopic(RedisTopicEnum.小红点.getTopic()));

        return redisMessageListenerContainer;
    }
}
