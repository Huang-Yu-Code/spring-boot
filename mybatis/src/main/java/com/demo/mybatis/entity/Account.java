package com.demo.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 项目: spring-boot
 * 时间: 2021/11/9 14:15
 *
 * @author HuangYu
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private Long bankId;
    private BigDecimal money;
    private Boolean locked;
    private Long version;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private Boolean delete;
}