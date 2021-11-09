package com.demo.mybatis.dao;

import com.demo.mybatis.entity.Page;
import com.demo.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目: spring-boot
 * 时间: 2021/10/23 2:38
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
     * @param user 用户
     * @return rows
     */
    int add(User user);

    /**
     * 查询
     *
     * @param id 用户ID
     * @return User
     */
    User get(@Param("id") long id);

    /**
     * 查询全部
     *
     * @return List<User>
     */
    List<User> getAll();

    /**
     * 分页查询
     *
     * @param page 分页
     * @return List<User>
     */
    List<User> getPage(Page page);

    /**
     * 更新
     *
     * @param user 用户
     * @return rows
     */
    int update(User user);

    /**
     * 删除
     *
     * @param user 用户
     * @return rows
     */
    int delete(User user);

}
