package com.demo.mybatis.dao;

import com.demo.mybatis.entity.Bank;
import com.demo.mybatis.util.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    private BankDao bankDao;

    @Test
    @DisplayName("新增")
    void add() {
        Bank bank = Bank.builder()
                .name("中国银行")
                .build();
        int rows = bankDao.add(bank);
        log.info("{}", bank);
        Assertions.assertEquals(1, rows);
    }

    @Test
    @DisplayName("查询")
    void get() {
        long id = 1L;
        Bank bank = bankDao.get(id);
        log.info("{}", bank);
        Assertions.assertNotNull(bank);
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        Page page = new Page();
        List<Bank> banks = bankDao.getPage(page);
        log.info("{}", banks);
        Assertions.assertNotNull(banks);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        List<Bank> banks = bankDao.getAll();
        log.info("{}", banks);
        Assertions.assertNotNull(banks);
    }

    @Test
    @DisplayName("更新")
    void update() {
        Bank bank = bankDao.get(1L);
        bank.setName("日本银行");
        int rows = bankDao.update(bank);
        log.info("{}", bank);
        Assertions.assertEquals(1, rows);
    }

    @Test
    @DisplayName("删除")
    void delete() {
        Bank bank = bankDao.get(1L);
        int rows = bankDao.delete(bank);
        Assertions.assertEquals(1, rows);
    }
}
