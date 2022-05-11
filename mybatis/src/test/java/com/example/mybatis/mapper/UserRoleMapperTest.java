package com.example.mybatis.mapper;

import com.example.mybatis.entity.UserRole;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 项目: mybatis
 * 时间: 2022/5/11 15:04
 * UserRoleMapper测试类
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
@Slf4j
class UserRoleMapperTest {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Test
    void insert() {
        UserRole userRole = new UserRole();
        userRole.setUserId(3L);
        userRole.setRoleId(3L);
        int rows = userRoleMapper.insert(userRole);
        Assertions.assertEquals(1, rows);
    }

    @Test
    void select() {
        PageHelper.startPage(1,2);
        List<UserRole> userRoles = userRoleMapper.select();
        PageInfo<UserRole> pageInfo = new PageInfo<>(userRoles);
        log.info("{}", userRoles);
        log.info("{}", pageInfo);
        Assertions.assertNotNull(userRoles);
    }

    @Test
    void selectOne() {
        UserRole userRole = userRoleMapper.selectOne(3L);
        log.info("{}", userRole);
        Assertions.assertNotNull(userRole);
    }

    @Test
    void delete() {
        UserRole userRole = new UserRole();
        userRole.setUserId(3L);
        userRole.setRoleId(3L);
        int rows = userRoleMapper.delete(userRole);
        Assertions.assertEquals(1, rows);
    }
}
