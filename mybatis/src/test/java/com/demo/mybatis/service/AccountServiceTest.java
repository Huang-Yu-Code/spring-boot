package com.demo.mybatis.service;

import com.demo.mybatis.entity.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * 项目: spring-boot
 * 时间: 2021/11/9 20:09
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("新增")
    void add() {
        long userId = 1L;
        long bankId = 1L;
        Assertions.assertNotNull(accountService.add(userId, bankId));
    }

    @Test
    @DisplayName("查询")
    void get() {
        long id = 1L;
        Assertions.assertNotNull( accountService.get(id));
    }


    @Test
    @DisplayName("查询全部")
    void getAll() {
        Assertions.assertNotEquals(0,accountService.getAll().length);
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        long currentPage = 1L;
        long pageSize = 10L;
        Assertions.assertNotEquals(0,accountService.getPage(currentPage, pageSize).length);
    }

    @Test
    @DisplayName("更新")
    void update() {
        long id = 1L;
        Account account = accountService.get(id);
        account.setMoney(new BigDecimal("2000.00"));
        Assertions.assertNotNull(accountService.update(account));
    }

    @Test
    @DisplayName("逻辑删除")
    void delete() {
        long id = 1L;
        Account account = accountService.get(id);
        accountService.delete(account);
    }
}
