package com.demo.mybatis.service;

import com.demo.mybatis.dao.AccountDao;
import com.demo.mybatis.entity.Account;
import com.demo.mybatis.entity.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 项目: spring-boot
 * 时间: 2021/10/23 3:05
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class AccountService {

    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account add(long userId, long bankId) {
        Account account = Account.builder().userId(userId).bankId(bankId).delete(false).build();
        List<Account> accounts = accountDao.getList(account);
        log.info("{}",accounts);
        Assert.isTrue(accounts.size()==0, "账户已存在");
        int rows = accountDao.add(account);
        Assert.isTrue(rows == 1, "新增失败");
        Long id = account.getId();
        return accountDao.get(id);
    }

    public Account update(Account account) {
        int rows = accountDao.update(account);
        Assert.isTrue(rows == 1, "更新失败");
        Long id = account.getId();
        return accountDao.get(id);
    }

    public Account get(long id) {
        Account account = accountDao.get(id);
        Assert.notNull(account, "未找到");
        return account;
    }

    public List<Account> getList(Account account) {
        return accountDao.getList(account);
    }

    public List<Account> getPage(long currentPage, long pageSize) {
        Page page = new Page(currentPage, pageSize);
        return accountDao.getPage(page);
    }

    public List<Account> getAll() {
        return accountDao.getAll();
    }

    public void delete(Account account) {
        int rows = accountDao.delete(account);
        Assert.isTrue(rows == 1, "删除失败");
    }
}
