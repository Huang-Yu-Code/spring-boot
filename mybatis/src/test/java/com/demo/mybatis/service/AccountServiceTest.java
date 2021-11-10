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

    @Test
    @DisplayName("新增")
    void add() {
        long userId = 1L;
        long bankId = 1L;
        Account account = accountService.add(
                Account.builder()
                        .userId(userId)
                        .bankId(bankId)
                        .build());
        log.info("{}", account);
        Assertions.assertNotNull(account);
    }

    @Test
    @DisplayName("查询")
    void get() {
        long id = 1L;
        Account account = accountService.get(Account.builder().id(id).delete(false).build());
        log.info("{}", account);
        Assertions.assertNotNull(account);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        List<Account> accounts = accountService.getAll();
        log.info("{}", accounts);
        Assertions.assertTrue(accounts.size() != 0);
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        List<Account> accounts = accountService.getPage(1L,10L);
        log.info("{}", accounts);
        Assertions.assertTrue(accounts.size() != 0);
    }

    @Test
    @DisplayName("更新")
    void update() {
        long id = 1L;
        Account account = accountService.get(Account.builder().id(id).delete(false).build());
        account.setMoney(new BigDecimal("2000.00"));
        Account update = accountService.update(account);
        log.info("{}", account);
        Assertions.assertNotNull(update);
    }

    @Test
    @DisplayName("逻辑删除")
    void delete() {
        long id = 1L;
        Account account = accountService.get(Account.builder().id(id).delete(false).build());
        accountService.delete(account);
    }
}
