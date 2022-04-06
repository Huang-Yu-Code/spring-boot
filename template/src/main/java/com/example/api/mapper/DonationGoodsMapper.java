package com.example.api.mapper;

import com.example.api.entity.DonationGoods;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/5 17:47
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface DonationGoodsMapper {

    List<DonationGoods> selectList(DonationGoods entity);

    void insert(List<DonationGoods> list);

    void delete(Long id);
}
