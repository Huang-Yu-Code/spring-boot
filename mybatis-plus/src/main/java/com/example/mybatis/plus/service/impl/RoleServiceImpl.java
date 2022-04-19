package com.example.mybatis.plus.service.impl;

import com.example.mybatis.plus.entity.Role;
import com.example.mybatis.plus.mapper.RoleMapper;
import com.example.mybatis.plus.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-20
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
