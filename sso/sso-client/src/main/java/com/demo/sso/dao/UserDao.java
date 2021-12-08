package com.demo.sso.dao;

import com.demo.sso.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 项目: spring-boot
 * 时间: 2021/11/25 2:10
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Repository
public interface UserDao {
    /**
     * 新增
     *
     * @return rows
     */
    int add();

    /**
     * 查询
     *
     * @return User
     */
    User get();

    /**
     * 更新
     *
     * @return rows
     */
    int update();

    /**
     * 删除
     *
     * @return rows
     */
    int delete();
}
