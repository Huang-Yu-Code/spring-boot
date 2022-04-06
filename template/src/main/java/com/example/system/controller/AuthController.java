package com.example.system.controller;

import com.example.common.entity.Response;
import com.example.common.enums.StatusCode;
import com.example.common.exception.CommonException;
import com.example.common.util.TokenUtils;
import com.example.system.entity.User;
import com.example.system.mapper.UserMapper;
import com.example.system.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/1 16:37
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserMapper userMapper;
    private final TokenUtils tokenUtils;

    @PostMapping("/login")
    public Response<String> login(@Validated @RequestBody User user) {
        user.setState(1L);
        List<UserVo> users = userMapper.selectList(user);
        if (users.isEmpty()) {
            throw new CommonException(StatusCode.USER_PASSWORD_ERROR);
        }
        UserVo userVo = users.get(0);
        log.info("vo{}:",userVo);
        Long id = userVo.getId();
        String username = userVo.getUsername();
        return Response.success(tokenUtils.create(id, username));
    }

    @PostMapping("/logout")
    public Response<Void> logout() {
        return Response.success();
    }
}
