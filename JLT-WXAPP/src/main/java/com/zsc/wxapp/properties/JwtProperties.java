package com.zsc.wxapp.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jlt.jwt")
@Data
public class JwtProperties {

    /**
     * 设置jwt相关配置消息
     */
    private String secretKey;
    private long ttl;
    private String tokenName;
}
