package com.yunhuchatbot.websockethandler;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.yunhuchatbot.Constant.SendConstant;
import com.yunhuchatbot.component.SessionManager;
import com.yunhuchatbot.entity.Payload;
import com.yunhuchatbot.entity.config.YunHuChat;
import com.yunhuchatbot.service.HandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * 转发MC服务器消息到群聊
 * @author xclhove
 */
@Component
public class ServeMessageHandler extends TextWebSocketHandler {
    @Autowired
    private HandlerService handlerService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        SessionManager.addSession(session);
        handlerService.sendMessageToGroup(message);
    }
}
