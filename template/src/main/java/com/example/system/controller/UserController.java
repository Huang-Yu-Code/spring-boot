package com.example.system.controller;

import com.example.common.entity.Response;
import com.example.common.enums.StatusCode;
import com.example.common.exception.CommonException;
import com.example.common.util.TokenUtils;
import com.example.system.entity.User;
import com.example.system.service.UserService;
import com.example.system.vo.Password;
import com.example.system.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/4 21:11
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
    private final UserService service;
    private final TokenUtils tokenUtils;

    @GetMapping("/")
    public Response<UserVo> select() {
        Long id = tokenUtils.getId();
        return Response.success(service.select(id));
    }

    @PutMapping("/password")
    public Response<Void> password(@RequestBody Password password) {
        service.updatePassword(password);
        return Response.success();
    }

    @GetMapping("/{id}")
    public Response<UserVo> select(@PathVariable Long id) {
        return Response.success(service.select(id));
    }

    @GetMapping("")
    public Response<List<UserVo>> selectList(User user) {
        return Response.success(service.selectList(user));
    }

    @PostMapping("")
    public Response<Void> insert(@RequestBody UserVo entity) {
        service.insert(entity);
        return Response.success();
    }

    @PutMapping("")
    public Response<Void> update(@RequestBody UserVo entity) {
        service.update(entity);
        return Response.success();
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return Response.success();
    }
}
