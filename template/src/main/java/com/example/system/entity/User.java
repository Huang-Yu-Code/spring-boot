package com.example.system.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 项目: template
 * 时间: 2022/4/4 21:18
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String password;
    private Long state;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
