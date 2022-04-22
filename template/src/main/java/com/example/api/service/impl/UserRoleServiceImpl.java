package com.example.api.service.impl;

import com.example.api.entity.UserRole;
import com.example.api.mapper.UserRoleMapper;
import com.example.api.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-21
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
