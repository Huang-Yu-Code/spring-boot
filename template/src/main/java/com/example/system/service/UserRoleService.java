package com.example.system.service;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/3/31 23:11
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface UserRoleService {
    List<String> list(String token);
}
