package com.example.system.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 项目: template
 * 时间: 2022/4/5 18:15
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class Password implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String oldPassword;
    private String newPassword;
}
