package com.example.api.service.impl;

import com.example.api.entity.Donation;
import com.example.api.entity.DonationGoods;
import com.example.api.entity.Goods;
import com.example.api.mapper.DonationGoodsMapper;
import com.example.api.mapper.DonationMapper;
import com.example.api.mapper.GoodsMapper;
import com.example.api.service.DonationService;
import com.example.api.vo.DonationVo;
import com.example.common.util.TokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目: template
 * 时间: 2022/4/5 17:42
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class DonationServiceImpl implements DonationService {

    private final DonationMapper mapper;
    private final GoodsMapper goodsMapper;
    private final DonationGoodsMapper donationGoodsMapper;
    private final TokenUtils tokenUtils;

    @Override
    public DonationVo select(Long id) {
        return mapper.select(id);
    }

    @Override
    public List<DonationVo> selectList(Donation entity) {
        return mapper.selectList(entity);
    }

    @Override
    public void insert(DonationVo entity) {
        Long userId = tokenUtils.getId();
        entity.setState(0L);
        entity.setUserId(userId);
        List<Goods> goodsList = entity.getGoods();
        Long warehouseId = entity.getWarehouseId();
        goodsList = goodsList.stream().map(goods -> {
            goods.setWarehouseId(warehouseId);
            goods.setState(0L);
            return goods;
        }).collect(Collectors.toList());
        goodsMapper.insert(goodsList);
        mapper.insert(entity);
        Long id = entity.getId();
        List<DonationGoods> donationGoodsList = goodsList.stream().map(goods -> {
            DonationGoods donationGoods = new DonationGoods();
            donationGoods.setDonationId(id);
            donationGoods.setGoodsId(goods.getId());
            return donationGoods;
        }).collect(Collectors.toList());
        donationGoodsMapper.insert(donationGoodsList);
    }

    @Override
    public void update(DonationVo entity) {
        mapper.update(entity);
        List<Goods> goods = entity.getGoods();
        for (Goods good : goods) {
            good.setState(1L);
            goodsMapper.update(good);
        }
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }
}
