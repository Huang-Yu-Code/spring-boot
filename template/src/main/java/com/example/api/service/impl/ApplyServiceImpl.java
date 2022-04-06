package com.example.api.service.impl;

import com.example.api.entity.Apply;
import com.example.api.entity.ApplyGoods;
import com.example.api.entity.DonationGoods;
import com.example.api.entity.Goods;
import com.example.api.mapper.ApplyGoodsMapper;
import com.example.api.mapper.ApplyMapper;
import com.example.api.mapper.GoodsMapper;
import com.example.api.service.ApplyService;
import com.example.api.vo.ApplyVo;
import com.example.common.util.TokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目: template
 * 时间: 2022/4/5 17:40
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class ApplyServiceImpl implements ApplyService {

    private final ApplyMapper mapper;
    private final TokenUtils tokenUtils;
    private final GoodsMapper goodsMapper;
    private final ApplyGoodsMapper applyGoodsMapper;

    @Override
    public ApplyVo select(Long id) {
        return mapper.select(id);
    }

    @Override
    public List<ApplyVo> selectList(Apply entity) {
        return mapper.selectList(entity);
    }

    @Override
    public void insert(ApplyVo entity) {
        Long userId = tokenUtils.getId();
        entity.setState(0L);
        entity.setUserId(userId);
        List<Goods> goodsList = entity.getGoods();
        mapper.insert(entity);
        Long id = entity.getId();
        List<ApplyGoods> applyGoodsList = goodsList.stream().map(goods -> {
            ApplyGoods applyGoods = new ApplyGoods();
            applyGoods.setApplyId(id);
            applyGoods.setGoodsId(goods.getId());
            return applyGoods;
        }).collect(Collectors.toList());
        applyGoodsMapper.insert(applyGoodsList);
    }

    @Override
    public void update(ApplyVo entity) {
        mapper.update(entity);
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }
}
