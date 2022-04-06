package com.example.system.service.impl;

import com.example.common.enums.StatusCode;
import com.example.common.exception.CommonException;
import com.example.common.util.TokenUtils;
import com.example.system.entity.Role;
import com.example.system.entity.User;
import com.example.system.entity.UserInfo;
import com.example.system.entity.UserRole;
import com.example.system.mapper.UserInfoMapper;
import com.example.system.mapper.UserMapper;
import com.example.system.mapper.UserRoleMapper;
import com.example.system.service.UserService;
import com.example.system.vo.Password;
import com.example.system.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目: template
 * 时间: 2022/4/4 21:12
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

    private final UserMapper mapper;
    private final UserInfoMapper userInfoMapper;
    private final UserRoleMapper userRoleMapper;
    private final TokenUtils tokenUtils;

    @Override
    public UserVo select(Long id) {
        return mapper.select(id);
    }

    @Override
    public List<UserVo> selectList(User entity) {
        return mapper.selectList(entity);
    }

    @Override
    public void insert(UserVo entity) {
        try {
            UserInfo userInfo = entity.getUserInfo();
            List<Role> roles = entity.getRoles();
            entity.setUsername(userInfo.getPhoneNumbers());
            entity.setPassword("123456");
            entity.setState(1L);
            mapper.insert(entity);
            Long id = entity.getId();
            userInfo.setUserId(id);
            userInfo.setImage("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            userInfoMapper.insert(userInfo);
            List<UserRole> userRoles = roles.stream().map(role -> {
                UserRole userRole = new UserRole();
                userRole.setUserId(id);
                userRole.setRoleId(role.getId());
                return userRole;
            }).collect(Collectors.toList());
            userRoleMapper.insert(userRoles);
        } catch (DuplicateKeyException e) {
            throw new CommonException(StatusCode.USERNAME_EXIST);
        }
    }

    @Override
    public void update(UserVo entity) {
        mapper.update(entity);
        userInfoMapper.update(entity.getUserInfo());
        userRoleMapper.delete(entity.getId());
        List<UserRole> userRoles = entity.getRoles().stream().map(role -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(entity.getId());
            userRole.setRoleId(role.getId());
            return userRole;
        }).collect(Collectors.toList());
        userRoleMapper.insert(userRoles);
    }

    @Override
    public void updatePassword(Password password) {
        Long id = tokenUtils.getId();
        User user = new User();
        user.setId(id);
        user.setPassword(password.getOldPassword());
        if (mapper.selectList(user).isEmpty()) {
            throw new CommonException(StatusCode.USER_PASSWORD_ERROR);
        }
        user.setPassword(password.getNewPassword());
        mapper.update(user);
    }

    @Override
    public void updateState(User entity) {

    }

    @Override
    public void delete(Long id) {
        userRoleMapper.delete(id);
        userInfoMapper.delete(id);
        mapper.delete(id);
    }
}
