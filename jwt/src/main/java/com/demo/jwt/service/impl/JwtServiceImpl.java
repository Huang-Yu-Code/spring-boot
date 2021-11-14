package com.demo.jwt.service.impl;

import com.demo.jwt.service.JwtService;
import com.demo.jwt.util.JwtUtils;
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
    public final static Map<String, String> USERS = new ConcurrentHashMap<>();
    public final static Map<String, String> TOKENS = new ConcurrentHashMap<>();

    @Override
    public void logon(String username, String password) {
        Assert.isTrue(!USERS.containsKey(username), "该用户名已被注册");
        USERS.put(username, password);
    }

    @Override
    public String login(String username, String password) {
        Assert.isTrue(USERS.containsKey(username), "用户名或密码错误");
        Assert.isTrue(Objects.equals(USERS.get(username), password), "用户名或密码错误");
        String token = JwtUtils.createToken(username);
        if (TOKENS.containsValue(username)) {
            for (String key : TOKENS.keySet()) {
                if (TOKENS.get(key).equals(username)){
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
