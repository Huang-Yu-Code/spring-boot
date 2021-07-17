package com.demo.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author codingob
 */
@Data
@TableName(value = "entity")
public class Entity {
    private Integer id;
    private String name;
    private Boolean gender;
    private BigDecimal money;
    private Timestamp createTime;
}
