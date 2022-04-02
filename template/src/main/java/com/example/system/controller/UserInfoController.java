package com.example.system.controller;

import com.example.common.enums.StatusCode;
import com.example.system.entity.Response;
import com.example.system.entity.UserInfo;
import com.example.system.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/1 16:29
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user/info")
public class UserInfoController {
    private final UserInfoService userInfoService;

    @GetMapping("/{token}")
    public Response one(@PathVariable String token) {
        UserInfo userInfo = userInfoService.one(token);
        return Response.success(StatusCode.SUCCESS, userInfo);
    }

    @GetMapping("")
    public Response list(UserInfo userInfo) {
        List<UserInfo> list = userInfoService.list(userInfo);
        return Response.success(StatusCode.SUCCESS, list);
    }
}
