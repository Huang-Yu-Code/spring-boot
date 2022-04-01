package com.example.template.service.impl;

import com.example.template.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 项目: template
 * 时间: 2022/3/31 23:09
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
}
