package com.example.mybatis.dto;

import com.example.mybatis.entity.Role;
import com.example.mybatis.entity.User;
import com.example.mybatis.entity.UserInfo;
import lombok.Data;

import java.util.List;

/**
 * 项目: Mybatis
 * 时间: 2022/5/11 20:28
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class UserDto {
    private User user;
    private UserInfo userInfo;
    private List<Role> roles;
}
