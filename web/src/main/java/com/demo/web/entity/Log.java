package com.demo.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 项目: spring-boot
 * 时间: 2021/11/12 17:30
 *
 * @author HuangYu
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String host;
    private Long uid;
    private String url;
    private String method;
    private String args;
    private Timestamp gmtCreate;
}
