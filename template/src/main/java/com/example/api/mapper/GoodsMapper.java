package com.example.api.mapper;

import com.example.api.entity.Goods;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/5 17:21
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface GoodsMapper {

    Goods select(Long id);

    List<Goods> selectList(Goods entity);

    void insert(List<Goods> list);

    void update(Goods entity);

    void delete(Long id);
}
