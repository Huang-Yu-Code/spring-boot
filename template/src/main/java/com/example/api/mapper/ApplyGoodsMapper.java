package com.example.api.mapper;

import com.example.api.entity.ApplyGoods;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/5 17:46
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface ApplyGoodsMapper {

    List<ApplyGoods> selectList(ApplyGoods entity);

    void insert(List<ApplyGoods> list);

    void delete(Long id);
}
