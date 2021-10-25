package com.demo.mybatis.service;

import com.demo.mybatis.dao.BankDao;
import com.demo.mybatis.model.Bank;
import com.demo.mybatis.model.BankBO;
import com.demo.mybatis.model.BankVO;
import com.demo.mybatis.model.Page;
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

    private final BankDao dao;

    public BankService(BankDao dao) {
        this.dao = dao;
    }

    public boolean create(BankBO bo) {
        Assert.notNull(bo, "为空");
        Bank model = new Bank();
        model.setBankName(bo.getBankName());
        model.setRegion(bo.getRegion());
        int rows = dao.create(model);
        return rows == 1;
    }

    public boolean create(List<BankBO> boList) {
        Assert.notNull(boList, "为空");
        boolean result = true;
        for (BankBO bo : boList) {
            result = result && create(bo);
        }
        return result;
    }

    public boolean update(BankBO bo) {
        Assert.notNull(bo, "为空");
        Bank model = new Bank();
        model.setBankId(bo.getBankId());
        model.setBankName(bo.getBankName());
        model.setRegion(bo.getRegion());
        int rows = dao.update(model);
        return rows == 1;
    }

    public boolean update(List<BankBO> boList) {
        Assert.notNull(boList, "为空");
        boolean result = true;
        for (BankBO bo : boList) {
            result = result && update(bo);
        }
        return result;
    }

    public BankVO get(String id) {
        Assert.notNull(id, "为空");
        BankVO vo = dao.get(id);
        log.info("get{}", vo);
        Assert.notNull(vo, "未找到");
        return vo;
    }

    public List<BankVO> getList(List<String> idList) {
        Assert.notNull(idList, "为空");
        List<BankVO> voList = dao.getList(idList);
        log.info("getList{}", voList);
        Assert.notEmpty(voList, "未找到");
        return voList;
    }

    public List<BankVO> getPage(long currentPage, long pageSize) {
        Page page = new Page(currentPage, pageSize);
        List<BankVO> voList = dao.getPage(page);
        log.info("getPage{}", voList);
        Assert.notEmpty(voList, "未找到");
        return voList;
    }

    public List<BankVO> getAll() {
        List<BankVO> voList = dao.getAll();
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
