package com.example.mybatis.plus.service.impl;

import com.example.mybatis.plus.entity.UserRole;
import com.example.mybatis.plus.mapper.UserRoleMapper;
import com.example.mybatis.plus.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-20
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
