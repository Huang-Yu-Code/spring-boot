package com.example.api.service;

import com.example.api.entity.Warehouse;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/5 15:41
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface WarehouseService {

    Warehouse select(Long id);

    List<Warehouse> selectList(Warehouse entity);

    void insert(Warehouse entity);

    void update(Warehouse entity);

    void delete(Long id);
}
