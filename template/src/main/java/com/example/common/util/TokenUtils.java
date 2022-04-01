package com.example.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 项目: template
 * 时间: 2022/3/31 23:31
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Component
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "token")
@Getter
@Setter
public class TokenUtils {
    private String signature;
    private long expiration;

    /**
     * @param id       ID
     * @param username username
     * @return token
     */
    public String create(long id, String username) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, signature)
                .claim("id", id)
                .claim("username", username)
                .compact();
    }

    /**
     * 获取载荷
     *
     * @param token token
     * @return 荷载
     */
    public Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(signature).parseClaimsJws(token).getBody();
    }

    /**
     * 获取用户ID
     *
     * @param token token
     * @return id
     */
    public Long getId(String token) {
        return getClaims(token).get("id", Long.class);
    }

    /**
     * 获取用户账号
     *
     * @param token token
     * @return username
     */
    public String getUsername(String token) {
        return getClaims(token).get("username", String.class);
    }
}
