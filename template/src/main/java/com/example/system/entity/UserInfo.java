package com.example.system.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * 项目: template
 * 时间: 2022/3/31 23:06
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class UserInfo {
    @TableId
    private Long id;
    private String name;
    private String image;
    private String idNumbers;
    private String phoneNumbers;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
}
