package com.example.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 项目: template
 * 时间: 2022/4/5 17:43
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class ApplyGoods implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long applyId;
    private Long goodsId;
}
