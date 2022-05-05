package com.example.jwt.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.UUID;

/**
 * 项目: spring-boot
 * 时间: 2021/11/16 19:45
 *
 * @author HuangYu
 * @version 1.0.0
 * @since JDK1.8
 */
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {
    private String issuer;
    private String audience;
    private String signature = UUID.randomUUID().toString();
    private String subject;
    private long expiration = 1000L * 60 * 15;
}
