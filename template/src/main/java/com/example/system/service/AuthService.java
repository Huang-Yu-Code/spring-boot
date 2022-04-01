package com.example.system.service;

import com.example.system.entity.User;

/**
 * 项目: template
 * 时间: 2022/4/1 16:38
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */

public interface AuthService {
    String login(User user);
    void logout();
}
