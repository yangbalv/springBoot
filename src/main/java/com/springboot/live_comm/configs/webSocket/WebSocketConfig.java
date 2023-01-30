package com.springboot.live_comm.configs.webSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;


/**
 * 说明：WebScoket配置处理器
 * 把处理器和拦截器注册到spring websocket中
 *
 * @author 张天一
 * @version 1.0
 * @date 23年01月19号09点44分
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer, WebSocketConfigurer {


    //注入处理器
    @Autowired
    private ChatWebSocketHandler webSocketHandler;
    @Autowired
    private ChatHandshakeInterceptor chatHandshakeInterceptor;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//添加一个群发与点对点消息发送的功能
        registry.enableSimpleBroker("/topic", "/queue");
        registry.setApplicationDestinationPrefixes("/app");
    }

    //    创建了一个/chat接口接受请求连接的的SockJS（请求chat则会与之创建一个sockJS连接）此后的信息将由sockJs进行发送
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").withSockJS();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        首先添加了一个ws的websocket的接口
//        页面请求 / ws时数据发送至websocket
        registry.addHandler(webSocketHandler, "/ws").addInterceptors(chatHandshakeInterceptor);


//        //添加一个处理器还有定义处理器的处理路径
//        registry.addHandler(webSocketHandler, "/ws").addInterceptors(chatHandshakeInterceptor);
//        /*
//         * 在这里我们用到.withSockJS()，SockJS是spring用来处理浏览器对websocket的兼容性，
//         * 目前浏览器支持websocket还不是很好，特别是IE11以下.
//         * SockJS能根据浏览器能否支持websocket来提供三种方式用于websocket请求，
//         * 三种方式分别是 WebSocket, HTTP Streaming以及 HTTP Long Polling
//         */
//        registry.addHandler(webSocketHandler, "/ws/sockjs").addInterceptors(chatHandshakeInterceptor).withSockJS();
    }
}
