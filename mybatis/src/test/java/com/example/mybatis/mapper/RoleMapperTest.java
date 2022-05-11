package com.example.mybatis.mapper;

import com.example.mybatis.entity.Role;
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
 * RoleMapper测试类
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
@Slf4j
class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    void insert() {
        Role role = new Role();
        role.setCode("insertTest");
        role.setName("插入测试");
        int rows = roleMapper.insert(role);
        Assertions.assertEquals(1, rows);
    }

    @Test
    void select() {
        PageHelper.startPage(1,2);
        List<Role> roles = roleMapper.select();
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        log.info("{}", roles);
        log.info("{}", pageInfo);
        Assertions.assertNotNull(roles);
    }

    @Test
    void selectOne() {
        Role role = roleMapper.selectOne(1L);
        log.info("{}", role);
        Assertions.assertNotNull(role);
    }

    @Test
    void update() {
        Role role = new Role();
        role.setId(5L);
        role.setCode("updateTest");
        role.setName("更新测试");
        int rows = roleMapper.update(role);
        Assertions.assertEquals(1, rows);
    }

    @Test
    void delete() {
        int rows = roleMapper.delete(5L);
        Assertions.assertEquals(1, rows);
    }
}
