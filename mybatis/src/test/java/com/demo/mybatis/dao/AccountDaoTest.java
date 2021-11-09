package com.demo.mybatis.dao;

import com.demo.mybatis.entity.Account;
import com.demo.mybatis.entity.Page;
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
 * 时间: 2021/10/24 2:24
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
@Slf4j
public class AccountDaoTest {

    @Autowired
    private AccountDao accountDao;

    @Test
    @DisplayName("新增")
    void add() {
        Account account = Account.builder()
                .userId(1L)
                .bankId(1L)
                .build();
        int rows = accountDao.add(account);
        log.info("{}", account);
        Assertions.assertEquals(1, rows);
    }

    @Test
    @DisplayName("查询")
    void get() {
        long id = 1L;
        Account account = accountDao.get(id);
        log.info("{}", account);
        Assertions.assertNotNull(account);
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        Page page = new Page();
        List<Account> accounts = accountDao.getPage(page);
        log.info("{}", accounts);
        Assertions.assertNotNull(accounts);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        List<Account> accounts = accountDao.getAll();
        log.info("{}", accounts);
        Assertions.assertNotNull(accounts);
    }

    @Test
    @DisplayName("更新")
    void update() {
        long id = 1L;
        Account account = accountDao.get(id);
        account.setMoney(new BigDecimal("2000.00"));
        int rows = accountDao.update(account);
        log.info("{}", account);
        Assertions.assertEquals(1, rows);
    }

    @Test
    @DisplayName("逻辑删除")
    void delete() {
        long id = 1L;
        Account account = accountDao.get(id);
        int rows = accountDao.delete(account);
        Assertions.assertEquals(1, rows);
    }
}
