package com.demo.mybatis.dao;

import com.demo.mybatis.entity.Account;
import com.demo.mybatis.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目: spring-boot
 * 时间: 2021/10/23 3:05
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Repository
public interface AccountDao {
    /**
     * 新增
     *
     * @param account 账户
     * @return rows
     */
    int add(Account account);

    /**
     * 查询
     *
     * @param id 账户ID
     * @return Account
     */
    Account get(@Param("id") long id);

    /**
     * 查询多个
     *
     * @param account 账户
     * @return List<Account>
     */
    List<Account> getList(Account account);

    /**
     * 查询全部
     *
     * @return List<Account>
     */
    List<Account> getAll();

    /**
     * 分页查询
     *
     * @param page page
     * @return List<Account>
     */
    List<Account> getPage(Page page);

    /**
     * 更新
     *
     * @param account 账户
     * @return rows
     */
    int update(Account account);

    /**
     * 删除
     *
     * @param account 账户
     * @return rows
     */
    int delete(Account account);
}
