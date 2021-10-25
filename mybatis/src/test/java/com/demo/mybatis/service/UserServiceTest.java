package com.demo.mybatis.service;

import com.demo.mybatis.model.UserBO;
import com.demo.mybatis.model.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
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
    @DisplayName("新增一个")
    void create() {
        UserBO bo = new UserBO();
        bo.setUsername("username");
        bo.setPassword("password");
        boolean result = service.create(bo);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("新增多个")
    void creates() {
        List<UserBO> boList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserBO bo = new UserBO();
            bo.setUsername("username");
            bo.setPassword("password");
            boList.add(bo);
        }
        boolean result = service.create(boList);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("更新一个")
    void update() {
        UserBO bo = new UserBO();
        bo.setUserId("be64f020-336c-11ec-ac29-0242ac120002");
        bo.setUsername("username" + System.currentTimeMillis());
        bo.setPassword("password");
        boolean result = service.update(bo);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("更新多个")
    void updates() {
        List<UserBO> boList = new ArrayList<>();
        String[] idList = {
                "2721c8ed-3422-11ec-ac29-0242ac120002",
                "2736c2ef-3422-11ec-ac29-0242ac120002",
                "2740a0b9-3422-11ec-ac29-0242ac120002",
                "2751a300-3422-11ec-ac29-0242ac120002",
                "2754616b-3422-11ec-ac29-0242ac120002",
                "27566e4c-3422-11ec-ac29-0242ac120002",
                "275f168c-3422-11ec-ac29-0242ac120002",
                "27638e3c-3422-11ec-ac29-0242ac120002",
                "276c2c04-3422-11ec-ac29-0242ac120002",
                "276fdc5b-3422-11ec-ac29-0242ac120002",
        };
        for (int i = 0; i < 10; i++) {
            UserBO bo = new UserBO();
            bo.setUserId(idList[i]);
            bo.setUsername("username" + System.currentTimeMillis());
            bo.setPassword("password");
            boList.add(bo);
        }
        boolean result = service.update(boList);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("查询一个")
    void get() {
        String id = "be64f020-336c-11ec-ac29-0242ac120002";
        UserVO userVO = service.get(id);
        Assertions.assertNotNull(userVO);
    }

    @Test
    @DisplayName("查询多个")
    void getList() {
        String[] idList = {
                "32682084-3376-11ec-ac29-0242ac120002",
                "be64f020-336c-11ec-ac29-0242ac120002",
                "d29a9036-3376-11ec-ac29-0242ac120002"
        };
        List<UserVO> voList = service.getList(Arrays.asList(idList));
        Assertions.assertNotNull(voList);
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        List<UserVO> voList = service.getPage(1L, 10L);
        Assertions.assertNotNull(voList);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        List<UserVO> voList = service.getAll();
        Assertions.assertNotNull(voList);
    }

    @Test
    @DisplayName("删除一个")
    void delete() {
        String id = "32682084-3376-11ec-ac29-0242ac120002";
        boolean result = service.delete(id);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("删除多个")
    void deletes() {
        String[] idList = {
                "d29a9036-3376-11ec-ac29-0242ac120002",
                "d2a43051-3376-11ec-ac29-0242ac120002"
        };
        boolean result = service.delete(Arrays.asList(idList));
        Assertions.assertTrue(result);
    }

}
