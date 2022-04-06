package com.example.system.mapper;

import com.example.system.entity.UserInfo;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/4 21:55
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface UserInfoMapper {

    UserInfo select(Long id);

    List<UserInfo> selectList(UserInfo entity);

    void insert(UserInfo entity);

    void update(UserInfo entity);

    void delete(Long id);
}
