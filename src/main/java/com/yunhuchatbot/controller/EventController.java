package com.yunhuchatbot.controller;

import com.yunhuchatbot.Constant.EventType;
import com.yunhuchatbot.entity.EventInfo;
import com.yunhuchatbot.entity.config.YunHuChat;
import com.yunhuchatbot.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xclhove
 */
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private YunHuChat yunHuChat;
    /**
     * 接收云湖事件推送
     */
    @PostMapping("/{token}")
    public void eventHandler(@PathVariable("token") String token, @RequestBody EventInfo eventInfo) {
        if (!yunHuChat.getToken().equals(token)) {
            System.out.println("云湖消息订阅接口token错误！");
            return;
        }
        //普通消息事件
        if (EventType.MESSAGE_RECEIVE_NORMAL.equals(eventInfo.getHeader().getEventType())) {
            eventService.sendMessageToService(eventInfo);
        }
    }
}