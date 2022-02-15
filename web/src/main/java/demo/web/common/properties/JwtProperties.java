package demo.web.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.UUID;


/**
 * 项目: spring-boot
 * 时间: 2021/11/16 11:26
 *
 * @author HuangYu
 * @version 1.0.0
 * @since JDK1.8
 */
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private String issuer;
    private String audience;
    private String signature = UUID.randomUUID().toString();
    private String subject ;
    private Long expiration = 1000L * 60 * 60 * 24 * 365;

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

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }
}
