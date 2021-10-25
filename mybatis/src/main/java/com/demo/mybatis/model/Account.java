package com.demo.mybatis.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 项目: spring-boot
 * 时间: 2021/10/23 3:02
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accountId;
    private String bankId;
    private String userId;
    private BigDecimal money;
    private Date creatTime;
    private Date updateTime;
    private boolean delete;
}
