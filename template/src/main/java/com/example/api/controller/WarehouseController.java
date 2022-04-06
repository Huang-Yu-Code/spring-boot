package com.example.api.controller;

import com.example.common.entity.Response;
import com.example.api.entity.Warehouse;
import com.example.api.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/5 15:36
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/warehouse")
public class WarehouseController {
    private final WarehouseService service;

    @GetMapping("/{id}")
    public Response<Warehouse> select(@PathVariable Long id) {
        return Response.success(service.select(id));
    }

    @GetMapping("")
    public Response<List<Warehouse>> selectList(Warehouse user) {
        return Response.success(service.selectList(user));
    }

    @PostMapping("")
    public Response<Void> insert(@RequestBody Warehouse entity) {
        service.insert(entity);
        return Response.success();
    }

    @PutMapping("")
    public Response<Void> update(@RequestBody Warehouse entity) {
        service.update(entity);
        return Response.success();
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return Response.success();
    }
}
