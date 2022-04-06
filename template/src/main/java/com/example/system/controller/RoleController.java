package com.example.system.controller;

import com.example.common.entity.Response;
import com.example.system.entity.Role;
import com.example.system.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/4 23:20
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/role")
public class RoleController {
    private final RoleService service;

    @GetMapping("/{id}")
    public Response<Role> select(@PathVariable Long id) {
        return Response.success(service.select(id));
    }

    @GetMapping("")
    public Response<List<Role>> selectList(Role user) {
        return Response.success(service.selectList(user));
    }

    @PostMapping("")
    public Response<Void> insert(@RequestBody Role entity) {
        service.insert(entity);
        return Response.success();
    }

    @PutMapping("")
    public Response<Void> update(@RequestBody Role entity) {
        service.update(entity);
        return Response.success();
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return Response.success();
    }
}
