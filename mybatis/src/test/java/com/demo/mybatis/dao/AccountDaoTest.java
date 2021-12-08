package com.demo.mybatis.dao;

import com.demo.mybatis.entity.Account;
import com.demo.mybatis.util.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * 项目: spring-boot
 * 时间: 2021/10/24 2:24
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
public class AccountDaoTest {

    @Autowired
    private AccountDao accountDao;

    @Test
    @DisplayName("新增")
    void add() {
        long userId = 1L;
        long bankId = 1L;
        Account account = new Account();
        account.setUserId(userId);
        account.setBankId(bankId);
        Assertions.assertEquals(1, accountDao.add(account));
    }

    @Test
    @DisplayName("查询")
    void get() {
        long id = 1L;
        Assertions.assertNotNull(accountDao.get(id));
    }

    @Test
    @DisplayName("分页查询")
    void getPage() {
        Page page = new Page();
        Assertions.assertNotEquals(0, accountDao.getPage(page).length);
    }

    @Test
    @DisplayName("查询全部")
    void getAll() {
        Assertions.assertNotEquals(0, accountDao.getAll().length);
    }

    @Test
    @DisplayName("更新")
    void update() {
        long id = 1L;
        Account account = accountDao.get(id);
        account.setMoney(new BigDecimal("2000.00"));
        Assertions.assertEquals(1, accountDao.update(account));
    }

    @Test
    @DisplayName("逻辑删除")
    void delete() {
        long id = 1L;
        Account account = accountDao.get(id);
        Assertions.assertEquals(1, accountDao.delete(account));
    }
}
