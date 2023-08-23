package com.yunhuchatbot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SendResult {

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("data")
    private DataDTO data;
    @JsonProperty("msg")
    private String msg;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("messageInfo")
        private MessageInfoDTO messageInfo;

        @NoArgsConstructor
        @Data
        public static class MessageInfoDTO {
            @JsonProperty("msgId")
            private String msgId;
            @JsonProperty("recvId")
            private String recvId;
            @JsonProperty("recvType")
            private String recvType;
        }
    }
}
