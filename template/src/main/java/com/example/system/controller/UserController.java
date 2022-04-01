package com.example.system.controller;

import com.example.common.enums.StatusCode;
import com.example.system.entity.Password;
import com.example.system.entity.Response;
import com.example.system.entity.User;
import com.example.system.service.UserService;
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

    @GetMapping("")
    public Response list(User user) {
        List<User> users = userService.list(user);
        return Response.success(StatusCode.SUCCESS, users);
    }

    @PostMapping("")
    public Response insert(@RequestBody User user) {
        userService.insert(user);
        return Response.success();
    }

    @PutMapping("/password")
    public Response updatePassword(@RequestBody Password password) {
        userService.updatePassword(password);
        return Response.success();
    }

    @PutMapping("/state")
    public Response updateState(@RequestBody User user) {
        userService.updateState(user);
        return Response.success();
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable long id){
        userService.delete(id);
        return Response.success();
    }

}
