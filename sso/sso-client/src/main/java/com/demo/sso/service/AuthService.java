package com.demo.sso.service;

import com.demo.sso.dto.Login;
import com.demo.sso.dto.Logon;

/**
 * 项目: spring-boot
 * 时间: 2021/11/22 16:27
 *
 * @author HuangYu
 * @version 1.0.0
 * @since JDK1.8
 */
public interface AuthService {
    /**
     * 注册
     *
     * @param logon 注册信息
     * @return data
     */
    Object logon(Logon logon);

    /**
     * 登录
     *
     * @param login 登录信息
     * @return data
     */
    Object login(Login login);

    /**
     * 注销
     */
    void logout();
}
