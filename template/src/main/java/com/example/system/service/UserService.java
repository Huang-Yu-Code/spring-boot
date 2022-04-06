package com.example.system.service;

import com.example.system.entity.User;
import com.example.system.vo.Password;
import com.example.system.vo.UserVo;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/4 21:11
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface UserService {

    UserVo select(Long id);

    List<UserVo> selectList(User entity);

    void insert(UserVo entity);

    void update(UserVo entity);

    void updatePassword(Password password);

    void updateState(User entity);

    void delete(Long id);
}
