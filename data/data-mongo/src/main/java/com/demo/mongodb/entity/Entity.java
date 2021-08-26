package com.demo.mongodb.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author codingob
 */
@Data
@Document("entity")
public class Entity {
    private Integer id;
    private String name;
    private Boolean gender;
    private BigDecimal money;
    private Timestamp createTime;
}
