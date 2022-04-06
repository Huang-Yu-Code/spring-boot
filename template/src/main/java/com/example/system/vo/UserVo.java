package com.example.system.vo;

import com.example.system.entity.Role;
import com.example.system.entity.User;
import com.example.system.entity.UserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/4 21:42
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class UserVo extends User {
    private UserInfo userInfo;
    private List<Role> roles;
}
