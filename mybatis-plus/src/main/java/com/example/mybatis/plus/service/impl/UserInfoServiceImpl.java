package com.example.mybatis.plus.service.impl;

import com.example.mybatis.plus.entity.UserInfo;
import com.example.mybatis.plus.mapper.UserInfoMapper;
import com.example.mybatis.plus.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-20
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
