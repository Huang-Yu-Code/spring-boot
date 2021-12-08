package com.demo.sso.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.UUID;

/**
 * 项目: spring-boot
 * 时间: 2021/11/23 1:30
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@ConfigurationProperties(prefix = "file")
public class TokenProperties {
    private String issuer = "server";
    private String audience = "client";
    private String signature = UUID.randomUUID().toString();
    private String subject = "auth";
    private Integer expiration = 60 * 60 * 24 * 7;

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getExpiration() {
        return expiration;
    }

    public void setExpiration(Integer expiration) {
        this.expiration = expiration;
    }
}
