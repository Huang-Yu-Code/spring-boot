package com.example.system.service;

import com.example.system.entity.Password;
import com.example.system.entity.User;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/3/31 15:22
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface UserService {

    List<User> list(User user);

    void insert(User user);

    void updatePassword(Password password);

    void updateState(User user);

    void delete(long id);
}
