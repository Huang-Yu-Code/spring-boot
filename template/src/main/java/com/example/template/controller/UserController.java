package com.example.template.controller;

import com.example.common.enums.StatusCode;
import com.example.common.util.Response;
import com.example.template.entity.User;
import com.example.template.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/3/31 15:23
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public Response select(@PathVariable long id) {
        User user = userService.select(id);
        return Response.success(StatusCode.SUCCESS, user);
    }

    @GetMapping("")
    public Response selectList(User user) {
        List<User> users = userService.selectList(user);
        return Response.success(StatusCode.SUCCESS, users);
    }

    @PostMapping("")
    public Response insert(@RequestBody User user){
        userService.insert(user);
        return Response.success(StatusCode.SUCCESS,null);
    }
}
