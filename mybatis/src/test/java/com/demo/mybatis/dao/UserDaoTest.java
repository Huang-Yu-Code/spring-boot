package com.demo.mybatis.dao;

import com.demo.mybatis.entity.User;
import com.demo.mybatis.util.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    @DisplayName("新增")
    void add() {
        User user = new User();
        user.setUsername("xxx");
        user.setPassword("123456");
        user.setName("test");
        Assertions.assertEquals(1, userDao.add(user));
    }

    @Test
    @DisplayName("查询")
    void get() {
        long id = 1L;
        Assertions.assertNotNull(userDao.get(id));
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        Page page = new Page(1, 10);
        Assertions.assertNotEquals(0, userDao.getPage(page).length);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        Assertions.assertNotEquals(0, userDao.getAll().length);
    }

    @Test
    @DisplayName("更新")
    void update() {
        long id = 1L;
        User user = userDao.get(id);
        user.setPassword("654321");
        Assertions.assertEquals(1, userDao.update(user));
    }

    @Test
    @DisplayName("删除")
    void delete() {
        long id = 1L;
        User user = userDao.get(id);
        Assertions.assertEquals(1, userDao.delete(user));
    }

    @Test
    @DisplayName("关联查询")
    void getAccount(){
        long id = 1L;
        Map<String, Object> account = userDao.getAccount(id);
        System.out.println(account);
        Assertions.assertNotNull(account);
    }
}
