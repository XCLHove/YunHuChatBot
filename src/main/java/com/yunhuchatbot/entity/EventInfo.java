package com.yunhuchatbot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 云湖消息订阅
 * @author xclhove
 */
@NoArgsConstructor
@Data
public class EventInfo {
    @JsonProperty("version")
    private String version;
    @JsonProperty("header")
    private Header header;
    @JsonProperty("event")
    private Event event;

    @NoArgsConstructor
    @Data
    public static class Header {
        @JsonProperty("eventId")
        private String eventId;
        @JsonProperty("eventType")
        private String eventType;
        @JsonProperty("eventTime")
        private Long eventTime;
    }

    @NoArgsConstructor
    @Data
    public static class Event {
        @JsonProperty("sender")
        private Sender sender;
        @JsonProperty("chat")
        private Chat chat;
        @JsonProperty("message")
        private Message message;

        @NoArgsConstructor
        @Data
        public static class Sender {
            @JsonProperty("senderId")
            private Integer senderId;
            @JsonProperty("senderType")
            private String senderType;
            @JsonProperty("senderUserLevel")
            private String senderUserLevel;
            @JsonProperty("senderNickname")
            private String senderNickname;
        }

        @NoArgsConstructor
        @Data
        public static class Chat {
            @JsonProperty("chatId")
            private Integer chatId;
            @JsonProperty("chatType")
            private String chatType;
        }

        @NoArgsConstructor
        @Data
        public static class Message {
            @JsonProperty("msgId")
            private String msgId;
            @JsonProperty("parentId")
            private String parentId;
            @JsonProperty("sendTime")
            private Long sendTime;
            @JsonProperty("chatId")
            private Integer chatId;
            @JsonProperty("chatType")
            private String chatType;
            @JsonProperty("contentType")
            private String contentType;
            @JsonProperty("content")
            private Content content;
            @JsonProperty("instructionId")
            private Integer instructionId;
            @JsonProperty("instructionName")
            private String instructionName;
            @JsonProperty("commandId")
            private Integer commandId;
            @JsonProperty("commandName")
            private String commandName;

            @NoArgsConstructor
            @Data
            public static class Content {
                @JsonProperty("text")
                private String text;
            }
        }
    }
}
