package com.example.mybatis.mapper;

import com.example.mybatis.dto.UserDto;
import com.example.mybatis.entity.User;
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
 * UserMapper测试类
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
@Slf4j
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void insert() {
        User user = new User();
        user.setUsername("123567");
        user.setPassword("1234567");
        user.setState(1L);
        int rows = userMapper.insert(user);
        Assertions.assertEquals(1, rows);
    }

    @Test
    void select() {
        PageHelper.startPage(1, 2);
        List<User> users = userMapper.select();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        log.info("{}", users);
        log.info("{}", pageInfo);
        Assertions.assertNotNull(users);
    }

    @Test
    void selectOne() {
        User user = userMapper.selectOne(3L);
        log.info("{}", user);
        Assertions.assertNotNull(user);
    }

    @Test
    void update() {
        User user = new User();
        user.setId(3L);
        user.setState(0L);
        int rows = userMapper.update(user);
        Assertions.assertEquals(1, rows);
    }

    @Test
    void delete() {
        int rows = userMapper.delete(3L);
        Assertions.assertEquals(1, rows);
    }

    @Test
    void get() {
        List<UserDto> userDtos = userMapper.get();
        log.info("{}", userDtos);
        Assertions.assertNotNull(userDtos);
    }

    @Test
    void getOne() {
        UserDto userDto = userMapper.getOne(1L);
        log.info("{}", userDto);
        Assertions.assertNotNull(userDto);
    }
}
