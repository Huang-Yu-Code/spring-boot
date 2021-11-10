package com.demo.mybatis.service;

import com.demo.mybatis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 项目: spring-boot
 * 时间: 2021/10/23 4:22
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    @DisplayName("新增")
    void add() {
        User user = User.builder()
                .username("xxx1234")
                .password("123456")
                .name("xxx2")
                .build();
        User add = service.add(user);
        Assertions.assertNotNull(add);
    }

    @Test
    @DisplayName("更新")
    void update() {
        User user = service.get(1L);
        user.setPassword("3306");
        User update = service.update(user);
        Assertions.assertNotNull(update);
    }

    @Test
    @DisplayName("查询")
    void get() {
        long id = 1L;
        User user = service.get(id);
        Assertions.assertNotNull(user);
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        List<User> users = service.getPage(1L, 10L);
        Assertions.assertNotNull(users);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        List<User> users = service.getAll();
        Assertions.assertNotNull(users);
    }

    @Test
    @DisplayName("逻辑删除")
    void delete() {
        User user = service.get(1L);
        service.delete(user);
    }

}
