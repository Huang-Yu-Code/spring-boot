package com.demo.mybatis.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 项目: spring-boot
 * 时间: 2021/10/24 1:48
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String username;
}
