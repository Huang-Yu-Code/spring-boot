package com.demo.mybatis.service;

import com.demo.mybatis.dao.UserDao;
import com.demo.mybatis.model.Page;
import com.demo.mybatis.model.User;
import com.demo.mybatis.model.UserBO;
import com.demo.mybatis.model.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 项目: spring-boot
 * 时间: 2021/10/23 2:46
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserService {

    private final UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public boolean create(UserBO bo) {
        Assert.notNull(bo, "为空");
        User model = new User();
        model.setUsername(bo.getUsername());
        model.setPassword(bo.getPassword());
        int rows = dao.create(model);
        return rows == 1;
    }

    public boolean create(List<UserBO> boList) {
        Assert.notEmpty(boList, "为空");
        boolean result = true;
        for (UserBO bo : boList) {
            result = result && create(bo);
        }
        return result;
    }

    public boolean update(UserBO bo) {
        Assert.notNull(bo, "为空");
        User model = new User();
        model.setUserId(bo.getUserId());
        model.setUsername(bo.getUsername());
        model.setPassword(bo.getPassword());
        int rows = dao.update(model);
        return rows == 1;
    }

    public boolean update(List<UserBO> boList) {
        Assert.notEmpty(boList, "为空");
        boolean result = true;
        for (UserBO bo : boList) {
            result = result && update(bo);
        }
        return result;
    }

    public UserVO get(String id) {
        Assert.notNull(id, "为空");
        UserVO vo = dao.get(id);
        log.info("get{}", vo);
        Assert.notNull(vo, "未找到");
        return vo;
    }

    public List<UserVO> getList(List<String> idList) {
        Assert.notNull(idList, "为空");
        List<UserVO> voList = dao.getList(idList);
        log.info("getList{}", voList);
        Assert.notEmpty(voList, "未找到");
        return voList;
    }

    public List<UserVO> getPage(long currentPage, long pageSize) {
        List<UserVO> voList = dao.getPage(new Page(currentPage, pageSize));
        log.info("getPage{}", voList);
        Assert.notEmpty(voList, "未找到");
        return voList;
    }

    public List<UserVO> getAll() {
        List<UserVO> voList = dao.getAll();
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
        Assert.notEmpty(idList, "为空");
        boolean result = true;
        for (String id : idList) {
            result = result && delete(id);
        }
        return result;
    }

}
