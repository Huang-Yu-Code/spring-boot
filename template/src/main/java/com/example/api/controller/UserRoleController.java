package com.example.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.api.entity.UserRole;
import com.example.api.service.IUserRoleService;
import com.example.common.entity.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户角色 前端控制器
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-21
 */
@RestController
@RequestMapping("/user-role")
@Slf4j
@RequiredArgsConstructor
public class UserRoleController {
    private final IUserRoleService service;

    @PostMapping("")
    public Response<Void> insert(@RequestBody UserRole entity) {
        service.save(entity);
        return Response.success();
    }

    @GetMapping()
    public Response<List<UserRole>> select(UserRole entity) {
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        Long userId = entity.getUserId();
        Long roleId = entity.getRoleId();
        queryWrapper.eq(!ObjectUtils.isEmpty(userId), "user_id", userId)
                .eq(!ObjectUtils.isEmpty(roleId), "role_id", roleId);
        List<UserRole> list = service.list(queryWrapper);
        return Response.success(list);
    }

    @PutMapping("")
    public Response<Void> update(@RequestBody UserRole entity) {
        service.updateById(entity);
        return Response.success();
    }

    @DeleteMapping("")
    public Response<Void> delete(UserRole entity) {
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        Long userId = entity.getUserId();
        Long roleId = entity.getRoleId();
        queryWrapper.eq(!ObjectUtils.isEmpty(userId), "user_id", userId)
                .eq(!ObjectUtils.isEmpty(roleId), "role_id", roleId);
        service.remove(queryWrapper);
        return Response.success();
    }
}
