package com.socket.point;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author liulei
 * @Description websocket配置
 * @create 2017/7/30 21:37
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig2 extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    /**
     * @Title: registerStompEndpoints
     * @Description: 添加websocket两个节点
     * @param: stompEndpointRegistry
     */
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //        stompEndpointRegistry.addEndpoint("/endpoint").withSockJS();
        stompEndpointRegistry.addEndpoint("/endpointchat").withSockJS();
    }

    @Override
    /**
     * @Title: configureMessageBroker
     * @Description: 增加消息代理
     * @param: registry
     */
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //        registry.enableSimpleBroker("/queue","/topic");
        registry.enableSimpleBroker("/queue");
    }
}
