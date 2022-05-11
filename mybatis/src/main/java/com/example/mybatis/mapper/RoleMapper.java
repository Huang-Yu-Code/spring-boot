package com.example.mybatis.mapper;

import com.example.mybatis.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目: mybatis
 * 时间: 2022/5/11 16:18
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Repository
public interface RoleMapper {
    int insert(Role role);

    List<Role> select();

    Role selectOne(@Param("id") Long id);

    int update(Role role);

    int delete(@Param("id") Long id);
}
