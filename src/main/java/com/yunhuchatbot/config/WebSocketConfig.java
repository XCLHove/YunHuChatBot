package com.yunhuchatbot.config;

import com.yunhuchatbot.entity.config.YunHuChat;
import com.yunhuchatbot.websockethandler.ServeMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author xclhove
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private YunHuChat yunHuChat;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler(), "/" + yunHuChat.getWebSocketPath() + "/" + yunHuChat.getToken()).setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler handler() {
        return new ServeMessageHandler();
    }
}
