package com.demo.mybatis.service;

import com.demo.mybatis.dao.UserDao;
import com.demo.mybatis.util.Page;
import com.demo.mybatis.entity.User;
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
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User add(User user) {
        int rows = userDao.add(user);
        Assert.isTrue(rows == 1, "新增失败");
        Long id = user.getId();
        return userDao.get(id);
    }

    public User update(User user) {
        int rows = userDao.update(user);
        Assert.isTrue(rows == 1, "更新失败");
        Long id = user.getId();
        return userDao.get(id);
    }

    public User get(long id) {
        User user = userDao.get(id);
        Assert.notNull(user, "查询失败");
        return user;
    }

    public List<User> getPage(long currentPage, long pageSize) {
        return userDao.getPage(new Page(currentPage, pageSize));
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public void delete(User user) {
        int rows = userDao.delete(user);
        Assert.isTrue(rows == 1, "删除失败");
    }

}
