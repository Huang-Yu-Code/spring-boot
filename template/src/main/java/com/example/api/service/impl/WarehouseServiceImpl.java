package com.example.api.service.impl;

import com.example.api.entity.Warehouse;
import com.example.api.mapper.WarehouseMapper;
import com.example.api.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/5 15:41
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseMapper mapper;

    @Override
    public Warehouse select(Long id) {
        return mapper.select(id);
    }

    @Override
    public List<Warehouse> selectList(Warehouse entity) {
        return mapper.selectList(entity);
    }

    @Override
    public void insert(Warehouse entity) {
        entity.setState(1L);
        mapper.insert(entity);
    }

    @Override
    public void update(Warehouse entity) {
        mapper.update(entity);
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }
}
