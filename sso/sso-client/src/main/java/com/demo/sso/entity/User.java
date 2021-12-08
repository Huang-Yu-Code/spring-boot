package com.demo.sso.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 项目: spring-boot
 * 时间: 2021/11/25 2:10
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
    private Boolean locked;
    private Long version;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private Boolean delete;
}
