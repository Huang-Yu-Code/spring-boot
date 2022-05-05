package com.example.template.common.entity;

import lombok.Data;

/**
 * 项目: spring-boot
 * 时间: 2022/4/28 3:12
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
