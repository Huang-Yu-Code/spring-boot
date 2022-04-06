package com.example.api.vo;

import com.example.api.entity.Apply;
import com.example.api.entity.Donation;
import com.example.api.entity.Goods;
import com.example.system.entity.UserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/5 18:51
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApplyVo extends Apply {
    private List<Goods> goods;
    private UserInfo userInfo;
}
