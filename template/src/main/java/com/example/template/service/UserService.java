package com.example.template.service;

import com.example.template.entity.User;

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
    User select(long id);
    List<User> selectList(User user);
    void insert(User user);
}
