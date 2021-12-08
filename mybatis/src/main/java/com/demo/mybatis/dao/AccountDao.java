package com.demo.mybatis.dao;

import com.demo.mybatis.entity.Account;
import com.demo.mybatis.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
     *  查询
     * @param userId 用户ID
     * @return Account[]
     */
    Account[] getByUserId(@Param("userId") long userId);

    /**
     *  查询
     * @param bankId 银行ID
     * @return Account[]
     */
    Account[] getByBankId(@Param("bankId") long bankId);

    /**
     * 查询
     * @param userId 用户ID
     * @param bankId 银行ID
     * @return Account[]
     */
    Account[] getByUserIdAndBankId(@Param("userId") long userId, @Param("bankId") long bankId);

    /**
     * 查询全部
     *
     * @return Account[]
     */
    Account[] getAll();

    /**
     * 分页查询
     *
     * @param page page
     * @return Account[]
     */
    Account[] getPage(Page page);

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
