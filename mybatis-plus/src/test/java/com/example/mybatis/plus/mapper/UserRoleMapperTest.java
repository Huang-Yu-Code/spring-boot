package com.example.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatis.plus.entity.User;
import com.example.mybatis.plus.entity.UserRole;
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
class UserRoleMapperTest {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Test
    void insert(){
        UserRole userRole = new UserRole();
        userRole.setUserId(1L);
        userRole.setRoleId(1L);
        int row = userRoleMapper.insert(userRole);
        Assertions.assertEquals(1,row);
    }

    @Test
    void update(){
        //User user = new User();
        //user.setId(1L);
        //user.setUsername("123456");
        //user.setPassword("1234567");
        //user.setState(1L);
        //int row = userRoleMapper.updateById(user);
        //Assertions.assertEquals(1,row);
    }

    @Test
    void selectById(){
        //User user = userRoleMapper.selectById(1);
        //System.out.println(user);
        //Assertions.assertNotNull(user);
    }

    @Test
    void selectList(){
        //QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //List<User> users = userRoleMapper.selectList(queryWrapper);
        //users.forEach(System.out::println);
        //Assertions.assertNotEquals(Collections.emptyList(),users);
    }

    @Test
    void deleteById(){
        //int row = userRoleMapper.deleteById(1L);
        //Assertions.assertEquals(1,row);
    }
}
