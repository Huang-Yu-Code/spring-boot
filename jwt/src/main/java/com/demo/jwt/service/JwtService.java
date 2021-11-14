package com.demo.jwt.service;

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
     * 注册
     * @param username 用户名
     * @param password 密码
     */
    void logon(String username,String password);
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
