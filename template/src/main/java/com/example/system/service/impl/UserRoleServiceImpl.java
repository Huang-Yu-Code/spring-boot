package com.example.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.util.TokenUtils;
import com.example.system.entity.Role;
import com.example.system.entity.UserRole;
import com.example.system.mapper.RoleMapper;
import com.example.system.mapper.UserRoleMapper;
import com.example.system.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目: template
 * 时间: 2022/4/1 16:31
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserRoleServiceImpl implements UserRoleService {

    private final TokenUtils tokenUtils;

    private final UserRoleMapper userRoleMapper;
    private final RoleMapper roleMapper;

    @Override
    public List<String> list(String token) {
        Long id = tokenUtils.getId(token);
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.select("role_id");
        userRoleQueryWrapper.eq("user_id", id);
        List<UserRole> userRoles = userRoleMapper.selectList(userRoleQueryWrapper);
        List<Long> list = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        //
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.select("code").in("id",list);
        List<Role> roles = roleMapper.selectList(roleQueryWrapper);

        return roles.stream().map(Role::getCode).collect(Collectors.toList());
    }
}
