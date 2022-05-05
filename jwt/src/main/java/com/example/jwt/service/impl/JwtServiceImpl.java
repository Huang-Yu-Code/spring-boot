package com.example.jwt.service.impl;

import com.example.jwt.entity.User;
import com.example.jwt.properties.JwtProperties;
import com.example.jwt.service.JwtService;
import com.example.jwt.util.JwtUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 项目: spring-boot
 * 时间: 2021/11/14 22:45
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
public class JwtServiceImpl implements JwtService {
    public static final Map<String, String> USERS = new ConcurrentHashMap<>();
    public static final Map<String, String> TOKENS = new ConcurrentHashMap<>();
    private final JwtProperties jwtProperties;

    public JwtServiceImpl(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    @Override
    public User get(String token) {
        String signature = jwtProperties.getSignature();
        String uid = JwtUtils.getUid(signature, token);
        return User.builder().username(uid).password(USERS.get(uid)).build();
    }

    @Override
    public void logon(String username, String password) {
        Assert.isTrue(!USERS.containsKey(username), "该用户名已被注册");
        USERS.put(username, password);
    }

    @Override
    public String login(String username, String password) {
        Assert.isTrue(USERS.containsKey(username), "用户名或密码错误");
        Assert.isTrue(Objects.equals(USERS.get(username), password), "用户名或密码错误");
        String issuer = jwtProperties.getIssuer();
        String audience = jwtProperties.getAudience();
        String signature = jwtProperties.getSignature();
        String subject = jwtProperties.getSubject();
        long expiration = jwtProperties.getExpiration();
        String token = JwtUtils.createToken(issuer, audience, signature, subject, expiration, username);
        if (TOKENS.containsValue(username)) {
            for (Map.Entry<String, String> entry : TOKENS.entrySet()) {
                String key = entry.getKey();
                if (key.equals(username)) {
                    TOKENS.remove(key);
                }
            }
        }
        TOKENS.put(token, username);
        return token;
    }

    @Override
    public void logout(String token) {
        TOKENS.remove(token);
    }
}
