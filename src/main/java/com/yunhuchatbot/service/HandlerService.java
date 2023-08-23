package com.yunhuchatbot.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.yunhuchatbot.Constant.SendConstant;
import com.yunhuchatbot.entity.Payload;
import com.yunhuchatbot.entity.config.YunHuChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

/**
 * @author xclhove
 */
@Service
public class HandlerService {
    @Autowired
    private YunHuChat yunHuChat;

    public void sendMessageToGroup(TextMessage message) {
        Payload payload = JSON.parseObject(message.getPayload(), Payload.class);
        Payload.Params params = payload.getParams();

        JSONObject content = new JSONObject();
        content.put(SendConstant.Content.TEXT, params.getMessage());

        JSONObject postData = new JSONObject();
        postData.put(SendConstant.RECV_TYPE, SendConstant.RecvType.GROUP);
        postData.put(SendConstant.RECV_ID, params.getGroupId());
        postData.put(SendConstant.CONTENT_TYPE, SendConstant.ContentType.TEXT);
        postData.put(SendConstant.CONTENT, content);

        //服务器消息转发到群聊
        HttpUtil.post(yunHuChat.getWebHookUrl(), postData.toString());
    }
}
