package com.demo.mybatis.dao;

import com.demo.mybatis.entity.Bank;
import com.demo.mybatis.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 项目: spring-boot
 * 时间: 2021/10/24 2:28
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Repository
public interface BankDao {
    /**
     * 新增
     *
     * @param bank 银行
     * @return rows
     */
    int add(Bank bank);

    /**
     * 查询单条
     *
     * @param id id
     * @return Bank
     */
    Bank get(@Param("id") long id);

    /**
     * 查询全部
     *
     * @return List<Bank>
     */
    Bank[] getAll();

    /**
     * 分页查询
     *
     * @param page 分页
     * @return List<Bank>
     */
    Bank[] getPage(Page page);

    /**
     * 更新
     *
     * @param bank 银行
     * @return rows
     */
    int update(Bank bank);

    /**
     * 删除
     *
     * @param bank 银行
     * @return rows
     */
    int delete(Bank bank);

}
