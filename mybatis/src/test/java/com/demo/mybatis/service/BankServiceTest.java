package com.demo.mybatis.service;

import com.demo.mybatis.entity.Bank;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
    private BankService bankService;

    @Test
    @DisplayName("新增")
    void add() {
        Bank bank = Bank.builder()
                .name("法国银行")
                .build();
        Bank add = bankService.add(bank);
        Assertions.assertNotNull(add);
    }

    @Test
    @DisplayName("更新")
    void update() {
        long id = 1L;
        Bank bank = bankService.get(id);
        bank.setName("中国银行");
        Bank update = bankService.update(bank);
        Assertions.assertNotNull(update);
    }

    @Test
    @DisplayName("查询")
    void get() {
        long id = 1L;
        Bank bank = bankService.get(id);
        Assertions.assertNotNull(bank);
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        List<Bank> voList = bankService.getPage(1L, 10L);
        Assertions.assertNotNull(voList);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        List<Bank> voList = bankService.getAll();
        Assertions.assertNotNull(voList);
    }

    @Test
    @DisplayName("逻辑删除")
    void delete() {
        long id = 1L;
        Bank bank = bankService.get(id);
        bankService.delete(bank);
    }

}
