package com.example.system.service;

import com.example.system.entity.Role;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/4 23:18
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface RoleService {

    Role select(Long id);

    List<Role> selectList(Role entity);

    void insert(Role entity);

    void update(Role entity);

    void delete(Long id);
}
