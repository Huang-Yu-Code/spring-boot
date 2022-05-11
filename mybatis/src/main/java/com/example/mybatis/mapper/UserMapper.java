package com.example.mybatis.mapper;

import com.example.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目: spring-boot
 * 时间: 2022/5/11 16:18
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Repository
public interface UserMapper {
    int insert(User user);

    List<User> select();

    User selectOne(@Param("id") Long id);

    int update(User user);

    int delete(@Param("id") Long id);
}
