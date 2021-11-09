package com.demo.mybatis.service;

import com.demo.mybatis.dao.BankDao;
import com.demo.mybatis.entity.Bank;
import com.demo.mybatis.entity.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 项目: spring-boot
 * 时间: 2021/10/24 2:28
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class BankService {

    private final BankDao bankDao;

    public BankService(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    public Bank add(Bank bank) {
        int rows = bankDao.add(bank);
        Assert.isTrue(rows == 1, "新增失败");
        return bankDao.get(bank.getId());
    }

    public Bank update(Bank bank) {
        int rows = bankDao.update(bank);
        Assert.isTrue(rows == 1, "更新失败");
        return bankDao.get(bank.getId());
    }

    public Bank get(long id) {
        Bank bank = bankDao.get(id);
        Assert.notNull(bank, "查询失败");
        return bank;
    }

    public List<Bank> getPage(long currentPage, long pageSize) {
        Page page = new Page(currentPage, pageSize);
        return bankDao.getPage(page);
    }

    public List<Bank> getAll() {
        return bankDao.getAll();
    }

    public void delete(Bank bank) {
        int rows = bankDao.delete(bank);
        Assert.isTrue(rows == 1, "删除失败");
    }

}
