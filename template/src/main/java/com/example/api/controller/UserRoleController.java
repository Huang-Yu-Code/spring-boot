package com.example.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.api.entity.Role;
import com.example.api.entity.UserRole;
import com.example.api.service.IRoleService;
import com.example.api.service.IUserRoleService;
import com.example.common.entity.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色 前端控制器
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-21
 */
@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserRoleController {
    private final IUserRoleService service;
    private final IRoleService roleService;


    @PostMapping("/{userId}/roles/{roleId}")
    public R<Void> insert(@PathVariable Long userId, @PathVariable Long roleId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        service.save(userRole);
        return R.success();
    }

    @GetMapping("/{userId}/roles")
    public R<List<Role>> select(@PathVariable Long userId) {
        List<Long> collect = service.list(new QueryWrapper<UserRole>().eq(!ObjectUtils.isEmpty(userId), "user_id", userId)).stream().map(UserRole::getRoleId).collect(Collectors.toList());
        List<Role> roles = roleService.list(new QueryWrapper<Role>().in("id", collect));
        return R.success(roles);
    }

    @DeleteMapping("/{userId}/roles/{roleId}")
    public R<Void> delete(@PathVariable Long userId, @PathVariable Long roleId) {
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(!ObjectUtils.isEmpty(userId), "user_id", userId)
                .eq(!ObjectUtils.isEmpty(roleId), "role_id", roleId);
        service.remove(queryWrapper);
        return R.success();
    }
}
