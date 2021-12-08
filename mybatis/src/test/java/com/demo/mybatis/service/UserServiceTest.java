package com.demo.mybatis.service;

import com.demo.mybatis.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 项目: spring-boot
 * 时间: 2021/10/23 4:22
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("新增")
    void add() {
        User user = new User();
        user.setUsername("xxx");
        user.setPassword("123456");
        user.setName("test");
        Assertions.assertNotNull(userService.add(user));
    }

    @Test
    @DisplayName("更新")
    void update() {
        long id = 1L;
        User user = userService.get(id);
        user.setPassword("3306");
        Assertions.assertNotNull(userService.update(user));
    }

    @Test
    @DisplayName("查询")
    void get() {
        long id = 1L;
        Assertions.assertNotNull(userService.get(id));
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        Assertions.assertNotEquals(0,userService.getPage(1L, 10L).length);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        Assertions.assertNotEquals(0,userService.getAll().length);
    }

    @Test
    @DisplayName("逻辑删除")
    void delete() {
        long id = 1L;
        User user = userService.get(id);
        userService.delete(user);
    }

}
