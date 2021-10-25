package com.demo.mybatis.dao;

import com.demo.mybatis.model.Bank;
import com.demo.mybatis.model.BankVO;
import com.demo.mybatis.model.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
     * @param model model
     * @return rows
     */
    int create(Bank model);

    /**
     * 更新
     *
     * @param model model
     * @return rows
     */
    int update(Bank model);

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
    BankVO get(@Param("id") String id);

    /**
     * 查询多条
     *
     * @param idList idList
     * @return VOList
     */
    List<BankVO> getList(List<String> idList);

    /**
     * 查询全部
     *
     * @return VOList
     */
    List<BankVO> getAll();

    /**
     * 分页查询
     *
     * @param page page
     * @return VOList
     */
    List<BankVO> getPage(Page page);

}
