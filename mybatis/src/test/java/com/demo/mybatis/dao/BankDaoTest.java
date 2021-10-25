package com.demo.mybatis.dao;

import com.demo.mybatis.model.Bank;
import com.demo.mybatis.model.BankVO;
import com.demo.mybatis.model.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * 项目: spring-boot
 * 时间: 2021/10/24 2:59
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
@Slf4j
public class BankDaoTest {
    @Autowired
    private BankDao dao;

    @Test
    @DisplayName("新增")
    void create() {
        Bank model = new Bank();
        model.setBankName("建设银行");
        model.setRegion("深圳市");
        int rows = dao.create(model);
        log.info("create:{}", model);
        Assertions.assertEquals(1, rows);
    }

    @Test
    @DisplayName("查询一个")
    void get() {
        String id = "183e8a7d-3435-11ec-ac29-0242ac120002";
        BankVO vo = dao.get(id);
        log.info("get:{}", vo);
        Assertions.assertNotNull(vo);
    }

    @Test
    @DisplayName("查询多个")
    void getList() {
        String[] idList = {
                "183e8a7d-3435-11ec-ac29-0242ac120002",
                "508c2bdc-3435-11ec-ac29-0242ac120002"};
        List<BankVO> VOList = dao.getList(Arrays.asList(idList));
        log.info("getList:{}", VOList);
        Assertions.assertNotNull(VOList);
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        Page page = new Page();
        List<BankVO> VOList = dao.getPage(page);
        log.info("getPage:{}", VOList);
        Assertions.assertNotNull(VOList);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        List<BankVO> VOList = dao.getAll();
        log.info("getAll:{}", VOList);
        Assertions.assertNotNull(VOList);
    }

    @Test
    @DisplayName("更新")
    void update() {
        String id = "183e8a7d-3435-11ec-ac29-0242ac120002";
        Bank model = new Bank();
        model.setBankId(id);
        model.setBankName("中国银行");
        model.setRegion("广州市");
        int rows = dao.update(model);
        log.info("update:{}", model);
        Assertions.assertEquals(rows, 1);
    }

    @Test
    @DisplayName("逻辑删除")
    void delete() {
        String id = "183e8a7d-3435-11ec-ac29-0242ac120002";
        int rows = dao.delete(id);
        Assertions.assertEquals(rows, 1);
    }
}
