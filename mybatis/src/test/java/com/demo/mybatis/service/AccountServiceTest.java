package com.demo.mybatis.service;

import com.demo.mybatis.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

/**
 * 项目: spring-boot
 * 时间: 2021/11/9 20:09
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
@Slf4j
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    private final long id = 1L;

    @Test
    @DisplayName("新增")
    void add() {
        long userId = 1L;
        long bankId = 1L;
        Account account = accountService.add(userId, bankId);
        log.info("{}", account);
        Assertions.assertNotNull(account);
    }

    @Test
    @DisplayName("查询")
    void get() {
        Account account = accountService.get(id);
        log.info("{}", account);
    }

    @Test
    @DisplayName("查询列表")
    void getList() {
        long userId = 1L;
        long bankId = 1L;
        Account account = Account.builder().userId(userId).bankId(bankId).build();
        List<Account> accounts = accountService.getList(account);
        log.info("{}", accounts);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        List<Account> accounts = accountService.getAll();
        log.info("{}", accounts);
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        long currentPage = 1L;
        long pageSize = 10L;
        List<Account> accounts = accountService.getPage(currentPage, pageSize);
        log.info("{}", accounts);
    }

    @Test
    @DisplayName("更新")
    void update() {
        Account account = accountService.get(id);
        account.setMoney(new BigDecimal("2000.00"));
        account = accountService.update(account);
        log.info("{}", account);
    }

    @Test
    @DisplayName("逻辑删除")
    void delete() {
        Account account = accountService.get(id);
        accountService.delete(account);
    }
}
