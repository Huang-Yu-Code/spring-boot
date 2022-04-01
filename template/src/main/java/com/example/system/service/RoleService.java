package com.example.system.service;

import com.example.system.entity.Role;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/3/31 23:11
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface RoleService {
    List<Role> list(Role role);

    void insert(Role role);

    void update(Role role);

    void delete(long id);
}
