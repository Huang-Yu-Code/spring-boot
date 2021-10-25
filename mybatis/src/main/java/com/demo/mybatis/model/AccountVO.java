package com.demo.mybatis.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 项目: spring-boot
 * 时间: 2021/10/24 2:39
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class AccountVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accountId;
    private String bankId;
    private String userId;
    private BigDecimal money;
}
