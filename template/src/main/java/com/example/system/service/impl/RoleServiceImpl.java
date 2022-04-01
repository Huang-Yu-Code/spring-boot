package com.example.system.service.impl;

import com.example.system.entity.Role;
import com.example.system.entity.User;
import com.example.system.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/3/31 23:12
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> list(Role role) {
        return null;
    }

    @Override
    public void insert(Role role) {

    }

    @Override
    public void update(Role role) {

    }

    @Override
    public void delete(long id) {

    }
}
