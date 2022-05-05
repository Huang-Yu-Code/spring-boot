package com.example.jwt.service;

import com.example.jwt.entity.User;

/**
 * 项目: spring-boot
 * 时间: 2021/11/14 22:44
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
public interface JwtService {
    /**
     * 查询
     *
     * @param token token
     * @return User
     */
    User get(String token);

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     */
    void logon(String username, String password);

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    String login(String username, String password);

    /**
     * 注销
     *
     * @param token token
     */
    void logout(String token);
}
