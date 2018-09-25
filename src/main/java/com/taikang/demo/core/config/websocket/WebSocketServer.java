package com.taikang.demo.core.config.websocket;

import com.taikang.demo.core.common.constant.RedisKeyEnum;
import com.taikang.demo.core.common.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Eunice
 * @date 2018/9/18
 */

@Slf4j
@ServerEndpoint(value = "/demo/pushMsg/{managerNo}")
@Component
public class WebSocketServer {

    @Resource
    private RedisTemplate redisTemplate;

    private String key = String.format(RedisKeyEnum.WebSocket连接数.getRedisKeyFormat(), "pushMsg");

    /**
     * 当前进程数
     */

    private static AtomicLong count = new AtomicLong(0L);

    /**
     * 存放每个连接对应的session对象
     */

    private static ConcurrentHashMap<String, Session> maps = new ConcurrentHashMap<>();

    /**
     * 连接建立时调用的方法
     * @param managerNo
     * @param session
     */

    @OnOpen
    public void onOpen(@PathParam("managerNo") String managerNo, Session session){
        maps.put(managerNo, session);
        count.incrementAndGet();
        Object obj = redisTemplate.opsForValue().get(key);
        if (Objects.isNull(obj)){
            redisTemplate.opsForValue().set(key, 1);
        }else {
            redisTemplate.opsForValue().increment(key, 1);
        }
        log.info("webSocket连接成功:/operator/pushMsg/{}", managerNo);
        sendMessage(managerNo, "连接成功");
    }

    /**
     * 连接关闭后的操作
     * @param managerNo
     */

    @OnClose
    public void onClose(@PathParam("managerNo") String managerNo){
        maps.remove(managerNo);
        count.decrementAndGet();
        redisTemplate.opsForValue().increment(key, -1);
        log.info("webSocket连接关闭:/operator/pushMsg/{}", managerNo);
    }

    /**
     * 收到客户端的消息后的操作
     * @param message
     * @param session
     */

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("webSocket客户端心跳:{}", message);
        session.getBasicRemote().sendText(message); //给指定用户发消息，这里的session就是该用户的session, session怎么拿?见sendMessage方法
    }

    /**
     * 发生错误后的操作
     * @param managerNo
     * @param error
     */

    @OnError
    public void onError(@PathParam("managerNo") String managerNo, Throwable error){
        log.error("webSocket出现异常, {}", error.getMessage());
    }

    /**
     * 发送消息的操作
     * @param managerNo
     * @param message
     */

    public BaseResponse<Object> sendMessage(String managerNo, String message) {
        Session session = maps.get(managerNo);  //建立连接时, 将session存储到map中, 发送消息时, 从map中取session
        if (Objects.nonNull(session)){
            try{
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                log.error("ws推送H5异常, {}", e);
                e.printStackTrace();
            }
            log.info("消息直推H5成功, 推送内容: managerNo<{}>, message<{}>", managerNo, message);
            return new BaseResponse<>(0, "推送H5成功");
        }else {
            log.info("消息直推H5失败,用户未上线 推送内容: managerNo<{}>, message<{}>", managerNo, message);
            return new BaseResponse<>(-1, "用户未上线");
        }
    }
}
