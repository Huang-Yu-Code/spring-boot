package com.example.system.mapper;

import com.example.system.entity.User;
import com.example.system.vo.UserVo;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/4 21:14
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface UserMapper {

    UserVo select(Long id);

    List<UserVo> selectList(User entity);

    void insert(User entity);

    void update(User entity);

    void delete(Long id);
}
