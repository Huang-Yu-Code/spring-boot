package com.demo.mybatis.dao;

import com.demo.mybatis.model.Page;
import com.demo.mybatis.model.User;
import com.demo.mybatis.model.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Slf4j
@DisplayName("UserDao")
public class UserDaoTest {

    @Autowired
    private UserDao dao;

    @Test
    @DisplayName("新增")
    void create() {
        User model = new User();
        model.setUsername("test-create-username");
        model.setPassword("test-create-password");
        int rows = dao.create(model);
        log.info("create:{}", model);
        Assertions.assertEquals(1, rows);
    }

    @Test
    @DisplayName("查询一个")
    void get() {
        String id = "be64f020-336c-11ec-ac29-0242ac120002";
        UserVO vo = dao.get(id);
        log.info("get:{}", vo);
        Assertions.assertNotNull(vo);
    }

    @Test
    @DisplayName("查询多个")
    void getList() {
        String[] idList = {
                "be64f020-336c-11ec-ac29-0242ac120002",
                "db134fcc-336c-11ec-ac29-0242ac120002"};
        List<UserVO> VOList = dao.getList(Arrays.asList(idList));
        log.info("getList:{}", VOList);
        Assertions.assertNotNull(VOList);
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        Page page = new Page(1, 10);
        List<UserVO> VOList = dao.getPage(page);
        log.info("getPage:{}", VOList);
        Assertions.assertNotNull(VOList);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        List<UserVO> VOList = dao.getAll();
        log.info("getAll:{}", VOList);
        Assertions.assertNotNull(VOList);
    }

    @Test
    @DisplayName("更新")
    void update() {
        String id = "be64f020-336c-11ec-ac29-0242ac120002";
        User model = new User();
        model.setUserId(id);
        model.setUsername("test-update-username");
        model.setPassword("test-update-password");
        int rows = dao.update(model);
        log.info("update:{}", model);
        Assertions.assertEquals(rows, 1);
    }

    @Test
    @DisplayName("逻辑删除")
    void delete() {
        String id = "be64f020-336c-11ec-ac29-0242ac120002";
        int rows = dao.delete(id);
        Assertions.assertEquals(rows, 1);
    }
}
