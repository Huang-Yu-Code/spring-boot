package com.example.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.api.entity.Role;
import com.example.api.service.IRoleService;
import com.example.common.entity.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-21
 */
@RestController
@RequestMapping("/role")
@Slf4j
@RequiredArgsConstructor
public class RoleController {
    private final IRoleService service;

    @PostMapping("")
    public Response<Void> insert(@RequestBody Role entity) {
        service.save(entity);
        return Response.success();
    }

    @GetMapping()
    public Response<List<Role>> select(Role entity) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        Long id = entity.getId();
        String code = entity.getCode();
        String name = entity.getName();
        queryWrapper.eq(!ObjectUtils.isEmpty(id), "id", id)
                .eq(StringUtils.hasText(code), "code", code)
                .eq(StringUtils.hasText(name), "name", name);
        List<Role> list = service.list(queryWrapper);
        return Response.success(list);
    }

    @PutMapping("")
    public Response<Void> update(@RequestBody Role entity) {
        service.updateById(entity);
        return Response.success();
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable Long id) {
        service.removeById(id);
        return Response.success();
    }
}
