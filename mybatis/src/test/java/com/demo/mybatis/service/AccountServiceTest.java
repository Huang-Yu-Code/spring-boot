package com.demo.mybatis.service;

import com.demo.mybatis.dao.AccountDao;
import com.demo.mybatis.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

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
    void add() {
        long userId = 1L;
        long bankId = 1L;
        Account account = accountService.add(
                Account.builder()
                        .userId(userId)
                        .bankId(bankId)
                        .build());
        Assertions.assertNotNull(account);
    }
}
