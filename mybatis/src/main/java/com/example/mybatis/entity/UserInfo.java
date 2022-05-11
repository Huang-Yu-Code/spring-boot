package com.example.mybatis.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 项目: mybatis
 * 时间: 2022/5/11 16:16
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class UserInfo {
    private Long id;
    private String name;
    private String image;
    private String idNumbers;
    private String phoneNumbers;
    private String email;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
