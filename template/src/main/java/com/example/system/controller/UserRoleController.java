package com.example.system.controller;

import com.example.common.enums.StatusCode;
import com.example.system.entity.Response;
import com.example.system.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/1 22:00
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user/role")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @GetMapping("/{token}")
    public Response list(@PathVariable String token) {
        List<String> roles = userRoleService.list(token);
        return Response.success(StatusCode.SUCCESS, roles);
    }
}
