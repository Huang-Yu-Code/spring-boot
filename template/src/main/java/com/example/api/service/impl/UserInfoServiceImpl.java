package com.example.api.service.impl;

import com.example.api.entity.UserInfo;
import com.example.api.mapper.UserInfoMapper;
import com.example.api.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-21
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
