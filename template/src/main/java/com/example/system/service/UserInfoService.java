package com.example.system.service;

import com.example.system.entity.UserInfo;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/3/31 23:11
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface UserInfoService {

    UserInfo one(String token);

    List<UserInfo> list(UserInfo userInfo);

    void insert(UserInfo userInfo);

    void update(UserInfo userInfo);

    void delete(long id);
}
