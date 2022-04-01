package com.example.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.util.TokenUtils;
import com.example.system.entity.User;
import com.example.system.service.AuthService;
import com.example.system.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 项目: template
 * 时间: 2022/4/1 16:43
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final TokenUtils tokenUtils;

    @Override
    public String login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("username", user.getUsername())
                .eq("password", user.getPassword());
        User one = userMapper.selectOne(queryWrapper);
        return tokenUtils.create(one.getId(), one.getUsername());
    }

    @Override
    public void logout() {
        log.info("注销");
    }
}
