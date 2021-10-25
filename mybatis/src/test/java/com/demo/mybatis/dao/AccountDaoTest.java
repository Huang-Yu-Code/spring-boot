package com.demo.mybatis.dao;

import com.demo.mybatis.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * 项目: spring-boot
 * 时间: 2021/10/24 2:24
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
@Slf4j
public class AccountDaoTest {

    @Autowired
    private AccountDao dao;

    @Test
    @DisplayName("新增")
    void create() {
        Account model = new Account();
        model.setBankId("508c2bdc-3435-11ec-ac29-0242ac120002");
        model.setUserId("2721c8ed-3422-11ec-ac29-0242ac120002");
        model.setMoney(new BigDecimal("1000.00"));
        int rows = dao.create(model);
        log.info("create:{}", model);
        Assertions.assertEquals(1, rows);
    }

    @Test
    @DisplayName("查询一个")
    void get() {
        String id = "a20cfcea-3444-11ec-ac29-0242ac120002";
        AccountVO vo = dao.get(id);
        log.info("get:{}", vo);
        Assertions.assertNotNull(vo);
    }

    @Test
    @DisplayName("查询多个")
    void getList() {
        String[] idList = {
                "a20cfcea-3444-11ec-ac29-0242ac120002",
                "0ee3a0e5-3446-11ec-ac29-0242ac120002"};
        List<AccountVO> VOList = dao.getList(Arrays.asList(idList));
        log.info("getList:{}", VOList);
        Assertions.assertNotNull(VOList);
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        Page page = new Page();
        List<AccountVO> VOList = dao.getPage(page);
        log.info("getPage:{}", VOList);
        Assertions.assertNotNull(VOList);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        List<AccountVO> VOList = dao.getAll();
        log.info("getAll:{}", VOList);
        Assertions.assertNotNull(VOList);
    }

    @Test
    @DisplayName("更新")
    void update() {
        String id = "a20cfcea-3444-11ec-ac29-0242ac120002";
        Account model = new Account();
        model.setAccountId(id);
        model.setMoney(new BigDecimal("2000.00"));
        int rows = dao.update(model);
        log.info("update:{}", model);
        Assertions.assertEquals(rows, 1);
    }

    @Test
    @DisplayName("逻辑删除")
    void delete() {
        String id = "a20cfcea-3444-11ec-ac29-0242ac120002";
        int rows = dao.delete(id);
        Assertions.assertEquals(rows, 1);
    }
}
