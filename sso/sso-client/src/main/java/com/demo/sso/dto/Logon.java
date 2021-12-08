package com.demo.sso.dto;

import lombok.Data;

/**
 * 项目: spring-boot
 * 时间: 2021/11/24 2:35
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class Logon {
    private String username;
    private String password;
    private String captcha;
}
