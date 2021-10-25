package com.demo.mybatis.service;

import com.demo.mybatis.dao.AccountDao;
import com.demo.mybatis.model.*;
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

    private final AccountDao dao;

    public AccountService(AccountDao dao) {
        this.dao = dao;
    }

    public boolean create(AccountBO bo) {
        Assert.notNull(bo, "为空");
        Account model = new Account();
        model.setUserId(bo.getUserId());
        model.setBankId(bo.getBankId());
        int rows = dao.create(model);
        return rows == 1;
    }

    public boolean create(List<AccountBO> boList) {
        Assert.notNull(boList, "为空");
        boolean result = true;
        for (AccountBO bo : boList) {
            result = result && create(bo);
        }
        return result;
    }

    public boolean update(AccountBO bo) {
        Assert.notNull(bo, "为空");
        Account model = new Account();
        model.setMoney(bo.getMoney());
        int rows = dao.update(model);
        return rows == 1;
    }

    public boolean update(List<AccountBO> boList) {
        Assert.notNull(boList, "为空");
        boolean result = true;
        for (AccountBO bo : boList) {
            result = result && update(bo);
        }
        return result;
    }

    public AccountVO get(String id) {
        Assert.notNull(id, "为空");
        AccountVO vo = dao.get(id);
        log.info("get{}", vo);
        Assert.notNull(vo, "未找到");
        return vo;
    }

    public List<AccountVO> getList(List<String> idList) {
        Assert.notNull(idList, "为空");
        List<AccountVO> voList = dao.getList(idList);
        log.info("getList{}", voList);
        Assert.notEmpty(voList, "未找到");
        return voList;
    }

    public List<AccountVO> getPage(long currentPage, long pageSize) {
        Page page = new Page(currentPage, pageSize);
        List<AccountVO> voList = dao.getPage(page);
        log.info("getPage{}", voList);
        Assert.notEmpty(voList, "未找到");
        return voList;
    }

    public List<AccountVO> getAll() {
        List<AccountVO> voList = dao.getAll();
        log.info("getAll{}", voList);
        Assert.notEmpty(voList, "未找到");
        return voList;
    }

    public boolean delete(String id) {
        Assert.notNull(id, "为空");
        int rows = dao.delete(id);
        return rows == 1;
    }

    public boolean delete(List<String> idList) {
        Assert.notNull(idList, "为空");
        boolean result = true;
        for (String id : idList) {
            result = result && delete(id);
        }
        return result;
    }
}
