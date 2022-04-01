package com.example.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.common.enums.StatusCode;
import com.example.common.exception.CommonException;
import com.example.common.util.TokenUtils;
import com.example.system.entity.Password;
import com.example.system.entity.User;
import com.example.system.entity.UserInfo;
import com.example.system.entity.UserRole;
import com.example.system.mapper.UserInfoMapper;
import com.example.system.mapper.UserMapper;
import com.example.system.mapper.UserRoleMapper;
import com.example.system.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目: template
 * 时间: 2022/3/31 15:22
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private final HttpServletRequest request;
    private final TokenUtils tokenUtils;
    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;
    private final UserInfoMapper userInfoMapper;

    @Override
    public List<User> list(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>(1);
        map.put("id", 1);
        wrapper.select("id", "username", "password", "state").allEq(map, true);
        return userMapper.selectList(wrapper);
    }

    @Override
    public void insert(User user) {
        try {
            userMapper.insert(user);
        } catch (DuplicateKeyException e) {
            log.error(StatusCode.USERNAME_EXIST.getMsg(), e);
            throw new CommonException(StatusCode.USERNAME_EXIST);
        }
    }

    @Override
    public void updatePassword(Password password) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        Long id = tokenUtils.getId(token);
        String newPassword = password.getNewPassword();
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        User user = new User();
        user.setId(id);
        user.setPassword(newPassword);
        userMapper.update(user, updateWrapper);
    }

    @Override
    public void updateState(User user) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        Long id = tokenUtils.getId(token);
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        userMapper.update(user, updateWrapper);
    }

    @Override
    public void delete(long id) {
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfoQueryWrapper.eq("id", id);
        userInfoMapper.delete(userInfoQueryWrapper);
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.eq("id", id);
        userRoleMapper.delete(userRoleQueryWrapper);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id", id);
        userMapper.delete(userQueryWrapper);
    }
}
