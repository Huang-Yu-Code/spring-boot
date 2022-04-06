package com.example.system.mapper;

import com.example.system.entity.UserRole;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/4 21:55
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface UserRoleMapper {

    List<UserRole> selectList(UserRole entity);

    void insert(List<UserRole> list);

    void delete(Long id);
}
