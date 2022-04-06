package com.example.system.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 项目: template
 * 时间: 2022/4/4 21:45
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long userId;
    private String name;
    private String image;
    private String idNumbers;
    private String phoneNumbers;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
