package com.example.api.controller;

import com.example.api.entity.Goods;
import com.example.api.service.GoodsService;
import com.example.common.entity.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/5 17:21
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsService service;

    @GetMapping("/{id}")
    public Response<Goods> select(@PathVariable Long id) {
        return Response.success(service.select(id));
    }

    @GetMapping("")
    public Response<List<Goods>> selectList(Goods user) {
        return Response.success(service.selectList(user));
    }

    @PutMapping("")
    public Response<Void> update(@RequestBody Goods entity) {
        service.update(entity);
        return Response.success();
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return Response.success();
    }
}
