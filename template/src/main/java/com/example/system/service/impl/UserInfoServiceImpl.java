package com.example.system.service.impl;

import com.example.system.entity.UserInfo;
import com.example.system.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public List<UserInfo> list(UserInfo userInfo) {
        return null;
    }

    @Override
    public UserInfo one() {
        return null;
    }

    @Override
    public void insert(UserInfo userInfo) {

    }

    @Override
    public void update(UserInfo userInfo) {

    }

    @Override
    public void delete(long id) {

    }
}
