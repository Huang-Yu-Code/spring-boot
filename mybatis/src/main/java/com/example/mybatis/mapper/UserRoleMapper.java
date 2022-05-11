package com.example.mybatis.mapper;

import com.example.mybatis.entity.UserRole;
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
public interface UserRoleMapper {
    int insert(UserRole userRole);

    List<UserRole> select();

    UserRole selectOne(@Param("id") Long id);

    int delete(UserRole userRole);
}
