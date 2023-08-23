package com.yunhuchatbot.entity.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xclhove
 */
@Data
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "yunhuchat")
public class YunHuChat {
    //websocket接口路径
    private String webSocketPath;
    private String webHookUrl;
    private String token;
}
