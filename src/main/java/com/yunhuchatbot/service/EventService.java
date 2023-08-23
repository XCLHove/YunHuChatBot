package com.yunhuchatbot.service;

import com.alibaba.fastjson2.JSONObject;
import com.yunhuchatbot.component.SessionManager;
import com.yunhuchatbot.entity.EventInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * @author xclhove
 */
@Service
@Slf4j
public class EventService {
    public void sendMessageToService(EventInfo eventInfo) {
        WebSocketSession webSocketSession = null;
        try {
            webSocketSession = SessionManager.getSession();
        } catch (Exception exception) {
            //webSocketSession = null;
        }
        if (webSocketSession == null) {
            System.out.println("服务器端未连接！");
            return;
        }

        String postType = "message";
        String messageType = eventInfo.getEvent().getMessage().getChatType();
        String subType = "normal";
        Integer messageId = null;
        Integer userId = eventInfo.getEvent().getSender().getSenderId();
        String message = eventInfo.getEvent().getMessage().getContent().getText();
        String rawMessage = message;
        Integer font = null;
        String nickname = eventInfo.getEvent().getSender().getSenderNickname();
        Integer groupId = eventInfo.getEvent().getChat().getChatId();
        String anonymous = null;
        Integer messageSeq = null;

        JSONObject sender = new JSONObject();
        sender.put("user_id", userId);
        sender.put("nickname", nickname);

        JSONObject sendMessage = new JSONObject();
        sendMessage.put("post_type", postType);
        sendMessage.put("message_type", messageType);
        sendMessage.put("sub_type", subType);
        sendMessage.put("message_id", messageId);
        sendMessage.put("user_id", userId);
        sendMessage.put("message", message);
        sendMessage.put("raw_message", rawMessage);
        sendMessage.put("font", font);
        sendMessage.put("sender", sender);
        sendMessage.put("group_id", groupId);
        sendMessage.put("anonymous", anonymous);
        sendMessage.put("message_seq", messageSeq);

        try {
            webSocketSession.sendMessage(new TextMessage(sendMessage.toString()));
        } catch (Exception exception) {
            log.error(exception.toString());
        }
    }
}
