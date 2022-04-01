package com.example.template.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * 项目: template
 * 时间: 2022/3/31 23:14
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class UserRole {
    private Long userId;
    private Long roleId;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
}
