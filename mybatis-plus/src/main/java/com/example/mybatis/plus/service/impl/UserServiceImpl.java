package com.example.mybatis.plus.service.impl;

import com.example.mybatis.plus.entity.User;
import com.example.mybatis.plus.mapper.UserMapper;
import com.example.mybatis.plus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
