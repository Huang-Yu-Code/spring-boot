package com.demo.mybatis.service;

import com.demo.mybatis.entity.Bank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 项目: spring-boot
 * 时间: 2021/10/24 3:16
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
public class BankServiceTest {

    @Autowired
    private BankService bankService;

    @Test
    @DisplayName("新增")
    void add() {
        Bank bank = new Bank();
        bank.setName("法国银行");
        Assertions.assertNotNull(bankService.add(bank));
    }

    @Test
    @DisplayName("更新")
    void update() {
        long id = 1L;
        Bank bank = bankService.get(id);
        bank.setName("中国银行");
        Assertions.assertNotNull(bankService.update(bank));
    }

    @Test
    @DisplayName("查询")
    void get() {
        long id = 1L;
        Assertions.assertNotNull(bankService.get(id));
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        Bank[] banks = bankService.getPage(1L, 10L);
        Assertions.assertNotEquals(0,banks.length);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        Bank[] banks = bankService.getAll();
        Assertions.assertNotEquals(0,banks.length);
    }

    @Test
    @DisplayName("逻辑删除")
    void delete() {
        long id = 1L;
        Bank bank = bankService.get(id);
        bankService.delete(bank);
    }

}
