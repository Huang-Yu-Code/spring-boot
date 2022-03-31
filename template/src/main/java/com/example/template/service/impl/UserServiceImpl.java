package com.example.template.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.enums.StatusCode;
import com.example.common.exception.CommonException;
import com.example.template.entity.User;
import com.example.template.mapper.UserMapper;
import com.example.template.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目: 修行宝
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
    private final UserMapper userMapper;

    @Override
    public User select(long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectList(User user) {
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
}
