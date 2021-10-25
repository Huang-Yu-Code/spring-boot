package com.demo.mybatis.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目: spring-boot
 * 时间: 2021/10/23 2:33
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String username;
    private String password;
    private Date creatTime;
    private Date updateTime;
    private boolean delete;
}
