package com.example.system.entity;

import lombok.Data;

/**
 * 项目: template
 * 时间: 2022/4/1 17:32
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class Password {
    private String oldPassword;
    private String newPassword;
}
