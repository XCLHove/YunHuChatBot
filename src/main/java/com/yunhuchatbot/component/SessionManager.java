package com.yunhuchatbot.component;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 会话管理
 *
 * @author xclhove
 */
@Component
public class SessionManager {
    // 使用 ConcurrentHashMap 存储会话信息
    private static volatile Map<Integer, WebSocketSession> sessions = new ConcurrentHashMap<>();

    /**
     * 添加会话
     *
     * @param webSocketSession 新建的会话
     */
    public static void addSession(WebSocketSession webSocketSession) {
        if (sessions.isEmpty()) {
            sessions.put(1, webSocketSession);
            return;
        }
        String oldId = getSession().getId();
        String newId = webSocketSession.getId();
        if (!oldId.equals(newId)) {
            sessions.put(1, webSocketSession);
        }
    }

    /**
     * 移除会话
     */
    public static void removeSession() {
        if (!sessions.isEmpty()) {
            sessions.remove(1);
        }
    }

    /**
     * 获取会话
     *
     * @return WebSocketSession
     */
    public static WebSocketSession getSession() {
        if (sessions.isEmpty()) {
            return null;
        }
        return sessions.get(1);
    }
}
