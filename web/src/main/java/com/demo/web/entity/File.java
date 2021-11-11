package com.demo.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 项目: spring-boot
 * 时间: 2021/11/11 17:06
 *
 * @author HuangYu
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class File implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String format;
    private Long size;
    private String url;
    private Long version;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private Boolean delete;
}