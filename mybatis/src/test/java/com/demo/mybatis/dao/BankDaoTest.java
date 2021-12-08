package com.demo.mybatis.dao;

import com.demo.mybatis.entity.Bank;
import com.demo.mybatis.util.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 项目: spring-boot
 * 时间: 2021/10/24 2:59
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
public class BankDaoTest {
    @Autowired
    private BankDao bankDao;

    @Test
    @DisplayName("新增")
    void add() {
        Bank bank = new Bank();
        bank.setName("中国银行");
        Assertions.assertEquals(1, bankDao.add(bank));
    }

    @Test
    @DisplayName("查询")
    void get() {
        long id = 1L;
        Assertions.assertNotNull(bankDao.get(id));
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        Page page = new Page();
        Assertions.assertNotEquals(0, bankDao.getPage(page).length);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        Assertions.assertNotEquals(0, bankDao.getAll().length);
    }

    @Test
    @DisplayName("更新")
    void update() {
        long id = 1L;
        Bank bank = bankDao.get(id);
        bank.setName("日本银行");
        Assertions.assertEquals(1, bankDao.update(bank));
    }

    @Test
    @DisplayName("删除")
    void delete() {
        Bank bank = bankDao.get(1L);
        int rows = bankDao.delete(bank);
        Assertions.assertEquals(1, rows);
    }
}
