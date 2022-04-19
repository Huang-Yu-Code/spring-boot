package com.example.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatis.plus.entity.Role;
import com.example.mybatis.plus.entity.User;
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
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void insert(){
        User user = new User();
        user.setUsername("123456");
        user.setPassword("123456");
        user.setState(1L);
        int row = userMapper.insert(user);
        Assertions.assertEquals(1,row);
    }

    @Test
    void update(){
        User user = new User();
        user.setId(1L);
        user.setUsername("123456");
        user.setPassword("1234567");
        user.setState(1L);
        int row = userMapper.updateById(user);
        Assertions.assertEquals(1,row);
    }

    @Test
    void selectById(){
        User user = userMapper.selectById(1);
        System.out.println(user);
        Assertions.assertNotNull(user);
    }

    @Test
    void selectList(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
        Assertions.assertNotEquals(Collections.emptyList(),users);
    }

    @Test
    void deleteById(){
        int row = userMapper.deleteById(1L);
        Assertions.assertEquals(1,row);
    }
}
