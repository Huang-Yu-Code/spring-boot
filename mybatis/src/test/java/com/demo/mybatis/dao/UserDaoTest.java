package com.demo.mybatis.dao;

import com.demo.mybatis.util.Page;
import com.demo.mybatis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    @DisplayName("新增")
    void add() {
        User user = User.builder()
                .username("xxx")
                .password("123456")
                .name("dev")
                .build();
        int rows = userDao.add(user);
        log.info("create:{}", user);
        Assertions.assertEquals(1, rows);
    }

    @Test
    @DisplayName("查询")
    void get() {
        long id = 1L;
        User user = userDao.get(id);
        log.info("{}", user);
        Assertions.assertNotNull(user);
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        Page page = new Page(1, 10);
        List<User> users = userDao.getPage(page);
        log.info("{}", users);
        Assertions.assertNotEquals(0, users.size());
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        List<User> users = userDao.getAll();
        log.info("{}", users);
        Assertions.assertNotEquals(0, users.size());
    }

    @Test
    @DisplayName("更新")
    void update() {
        User user = userDao.get(1L);
        user.setPassword("654321");
        int rows = userDao.update(user);
        log.info("update:{}", user);
        Assertions.assertEquals(1, rows);
    }

    @Test
    @DisplayName("删除")
    void delete() {
        User user = userDao.get(1L);
        int rows = userDao.delete(user);
        Assertions.assertEquals(1, rows);
    }
}
