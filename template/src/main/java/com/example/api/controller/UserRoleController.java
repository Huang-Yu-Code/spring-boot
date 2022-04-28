package com.example.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.api.entity.Role;
import com.example.api.entity.UserRole;
import com.example.api.service.IRoleService;
import com.example.api.service.IUserRoleService;
import com.example.common.entity.R;
import com.example.common.enums.StatusCode;
import com.example.common.exception.CommonException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    private final IUserRoleService iUserRoleService;
    private final IRoleService iRoleService;


    @PostMapping("/{userId}/roles/{roleId}")
    public R<Void> insert(@PathVariable Long userId, @PathVariable Long roleId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        try {
            iUserRoleService.save(userRole);
        } catch (DuplicateKeyException e) {
            throw new CommonException(StatusCode.USER_ROLE_EXIST);
        }
        return R.success();
    }

    @GetMapping("/{userId}/roles")
    public R<List<Role>> select(@PathVariable Long userId) {
        List<Long> collect = iUserRoleService.list(new QueryWrapper<UserRole>().eq(!ObjectUtils.isEmpty(userId), "user_id", userId)).stream().map(UserRole::getRoleId).collect(Collectors.toList());
        if (ObjectUtils.isEmpty(collect)){
            return R.success(Collections.emptyList());
        }
        List<Role> roles = iRoleService.list(new QueryWrapper<Role>().in("id", collect));
        return R.success(roles);
    }

    @DeleteMapping("/{userId}/roles/{roleId}")
    public R<Void> delete(@PathVariable Long userId, @PathVariable Long roleId) {
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(!ObjectUtils.isEmpty(userId), "user_id", userId)
                .eq(!ObjectUtils.isEmpty(roleId), "role_id", roleId);
        iUserRoleService.remove(queryWrapper);
        return R.success();
    }
}
