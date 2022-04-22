package com.example.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.api.entity.Role;
import com.example.api.entity.User;
import com.example.api.entity.UserRole;
import com.example.api.service.IRoleService;
import com.example.api.service.IUserRoleService;
import com.example.api.service.IUserService;
import com.example.common.entity.Login;
import com.example.common.entity.Response;
import com.example.common.enums.StatusCode;
import com.example.common.exception.CommonException;
import com.example.common.util.TokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 鉴权 前端控制器
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-21
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthController {
    private final TokenUtils tokenUtils;
    private final IUserService service;
    private final IUserRoleService userRoleService;
    private final IRoleService roleService;

    @PostMapping("/login")
    public Response<String> login(@RequestBody Login login) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        String username = login.getUsername();
        String password = login.getPassword();
        queryWrapper.eq("username", username).eq("password", password);
        User user = service.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(user)) {
            throw new CommonException(StatusCode.USERNAME_OR_PASSWORD_ERROR);
        }
        Long state = user.getState();
        if (!state.equals(1L)) {
            throw new CommonException(StatusCode.USER_STATE_EXCEPTION);
        }
        Long id = user.getId();
        return Response.success(tokenUtils.create(id, username));
    }

    @GetMapping("/roles")
    public Response<List<Role>> roles() {
        Long id = tokenUtils.getId();
        List<UserRole> userRoles = userRoleService.list(new QueryWrapper<UserRole>().eq("user_id", id));
        if (ObjectUtils.isEmpty(userRoles)) {
            return Response.success(Collections.emptyList());
        }
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList()));
        List<Role> list = roleService.list(queryWrapper);
        return Response.success(list);
    }

    @PostMapping("/logout")
    public Response<Void> logout() {
        return Response.success();
    }
}
