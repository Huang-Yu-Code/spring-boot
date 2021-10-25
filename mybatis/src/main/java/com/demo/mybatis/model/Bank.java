package com.demo.mybatis.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目: spring-boot
 * 时间: 2021/10/24 2:25
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class Bank implements Serializable {
    private static final long serialVersionUID = 1L;
    private String bankId;
    private String bankName;
    private String region;
    private Date createTime;
    private Date updateTime;
    private boolean delete;
}
