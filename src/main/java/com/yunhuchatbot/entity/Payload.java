package com.yunhuchatbot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@lombok.NoArgsConstructor
@lombok.Data
public class Payload {
    @JsonProperty("action")
    private String action;
    @JsonProperty("params")
    private Params params;

    @NoArgsConstructor
    @Data
    public static class Params {
        @JsonProperty("group_id")
        private String groupId;
        @JsonProperty("message")
        private String message;
        @JsonProperty("auto_escape")
        private Boolean autoEscape;
    }
}
