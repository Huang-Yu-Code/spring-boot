package com.example.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatis.plus.entity.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

/**
 * 项目: mybatis-plus
 * 时间: 2022/4/20 3:16
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    void insert(){
        Role role = new Role();
        role.setCode("test");
        role.setName("测试角色");
        int row = roleMapper.insert(role);
        Assertions.assertEquals(1,row);
    }

    @Test
    void update(){
        Role role = new Role();
        role.setId(1L);
        role.setCode("test");
        role.setName("测试角色2");
        int row = roleMapper.updateById(role);
        Assertions.assertEquals(1,row);
    }

    @Test
    void selectById(){
        Role role = roleMapper.selectById(1);
        Assertions.assertNotNull(role);
    }

    @Test
    void selectList(){
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        List<Role> roles = roleMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
        Assertions.assertNotEquals(Collections.emptyList(),roles);
    }

    @Test
    void deleteById(){
        int row = roleMapper.deleteById(1L);
        Assertions.assertEquals(1,row);
    }
}
