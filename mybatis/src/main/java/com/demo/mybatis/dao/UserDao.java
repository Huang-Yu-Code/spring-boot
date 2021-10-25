package com.demo.mybatis.dao;

import com.demo.mybatis.model.*;
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
     * @param model model
     * @return rows
     */
    int create(User model);

    /**
     * 更新
     *
     * @param model model
     * @return rows
     */
    int update(User model);

    /**
     * 删除
     *
     * @param id id
     * @return rows
     */
    int delete(@Param("id") String id);

    /**
     * 查询单条
     *
     * @param id id
     * @return VO
     */
    UserVO get(@Param("id") String id);

    /**
     * 查询多条
     *
     * @param idList idList
     * @return VOList
     */
    List<UserVO> getList(List<String> idList);

    /**
     * 查询全部
     *
     * @return VOList
     */
    List<UserVO> getAll();

    /**
     * 分页查询
     *
     * @param page page
     * @return VOList
     */
    List<UserVO> getPage(Page page);

}
