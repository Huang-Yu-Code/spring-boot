package com.example.api.vo;

import com.example.api.entity.Warehouse;
import com.example.system.entity.UserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 项目: template
 * 时间: 2022/4/5 16:28
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WarehouseVo extends Warehouse {
    private UserInfo userInfo;
}
