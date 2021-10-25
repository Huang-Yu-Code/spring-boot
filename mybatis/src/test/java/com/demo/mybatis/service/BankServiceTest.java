package com.demo.mybatis.service;

import com.demo.mybatis.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * 项目: spring-boot
 * 时间: 2021/10/24 3:16
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
@Slf4j
public class BankServiceTest {

    @Autowired
    private BankService service;

    @Test
    @DisplayName("新增一个")
    void create() {
        BankBO bo = new BankBO();
        bo.setBankName("中国工商银行");
        bo.setRegion("深圳市");
        boolean result = service.create(bo);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("新增多个")
    void creates() {
        List<BankBO> boList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BankBO bo = new BankBO();
            bo.setBankName("中国工商银行");
            bo.setRegion("深圳市");
            boList.add(bo);
        }
        boolean result = service.create(boList);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("更新一个")
    void update() {
        String id = "7f736c20-3440-11ec-ac29-0242ac120002";
        BankBO bo = new BankBO();
        bo.setBankId(id);
        bo.setBankName("中国银行");
        bo.setRegion("兴宁市");
        boolean result = service.update(bo);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("更新多个")
    void updates() {
        List<BankBO> boList = new ArrayList<>();
        String[] idList = {
                "7f736c20-3440-11ec-ac29-0242ac120002",
                "7f7006fc-3440-11ec-ac29-0242ac120002",
        };
        for (String id : idList) {
            BankBO bo = new BankBO();
            bo.setBankId(id);
            bo.setBankName("中国银行" + System.currentTimeMillis());
            bo.setRegion("兴宁市");
            boList.add(bo);
        }
        boolean result = service.update(boList);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("查询一个")
    void get() {
        String id = "7f736c20-3440-11ec-ac29-0242ac120002";
        BankVO vo = service.get(id);
        Assertions.assertNotNull(vo);
    }

    @Test
    @DisplayName("查询多个")
    void getList() {
        String[] idList = {
                "7f736c20-3440-11ec-ac29-0242ac120002",
                "7f7006fc-3440-11ec-ac29-0242ac120002",
        };
        List<BankVO> voList = service.getList(Arrays.asList(idList));
        Assertions.assertNotNull(voList);
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        List<BankVO> voList = service.getPage(1L, 10L);
        Assertions.assertNotNull(voList);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        List<BankVO> voList = service.getAll();
        Assertions.assertNotNull(voList);
    }

    @Test
    @DisplayName("删除一个")
    void delete() {
        String id = "7f6db630-3440-11ec-ac29-0242ac120002";
        boolean result = service.delete(id);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("删除多个")
    void deletes() {
        String[] idList = {
                "7f6729af-3440-11ec-ac29-0242ac120002",
                "7f5f6640-3440-11ec-ac29-0242ac120002"
        };
        boolean result = service.delete(Arrays.asList(idList));
        Assertions.assertTrue(result);
    }

}
