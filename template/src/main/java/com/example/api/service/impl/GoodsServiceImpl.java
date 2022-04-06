package com.example.api.service.impl;

import com.example.api.entity.Goods;
import com.example.api.mapper.GoodsMapper;
import com.example.api.service.GoodsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/5 17:21
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class GoodsServiceImpl implements GoodsService {

    private final GoodsMapper mapper;

    @Override
    public Goods select(Long id) {
        return mapper.select(id);
    }

    @Override
    public List<Goods> selectList(Goods entity) {
        return mapper.selectList(entity);
    }

    @Override
    public void update(Goods entity) {
        mapper.update(entity);
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }
}
