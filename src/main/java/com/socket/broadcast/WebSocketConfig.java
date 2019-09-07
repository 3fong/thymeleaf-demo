package com.socket.broadcast;

/**
 * @author liulei
 * @Description websocket 配置类,使用STOMP协议开启websocket.
 * @create 2017/7/28 10:35
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{


    @Override
    /**
     * @Title: registerStompEndpoints
     * @Description: 注册STOMP节点,并映射指定的url
     * @param: stompEndpointRegistry
     */
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/endpoint").withSockJS();
    }

    @Override
    /**
     * @Title: configureMessageBroker
     * @Description: 配置消息代理
     * @param: registry
     */
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
