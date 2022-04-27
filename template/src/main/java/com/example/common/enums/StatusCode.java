package com.example.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 项目: template
 * 时间: 2022/3/24 23:33
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@AllArgsConstructor
@Getter
public enum StatusCode {
    // 成功
    SUCCESS(200, "success"),
    // 失败
    FAILURE(400, "failure"),
    // TOKEN
    TOKEN_NULL(401, "未认证"),
    TOKEN_EXPIRED(401, "登录已过期"),
    TOKEN_ERROR(401, "非法认证"),
    USERNAME_OR_PASSWORD_ERROR(400, "账号或密码错误"),
    USER_STATE_EXCEPTION(400, "账号状态异常"),
    USERINFO_NO_EXIST(400, "用户信息不存在"),
    USERNAME_EXIST(400, "账号已存在"),
    BIND_EXCEPTION(400, "接口参数错误"),
    // USER
    USER_PASSWORD_ERROR(400, "密码错误"),
    // USER_ROLE
    USER_ROLE_EXIST(400, "重复授权"),
    // ROLE
    ROLE_NAME_EXIST(400, "角色已存在"),
    ROLE_CODE_EXIST(400, "标识符已存在"),
    // MINIO
    MINIO_EXCEPTION(400, "文件服务器异常"),
    MINIO_UPLOAD_EXCEPTION(400, "文件上传异常"),
    MINIO_DELETE_EXCEPTION(400, "文件删除异常"),
    SERVER_EXCEPTION(500, "服务器异常");

    private final int code;
    private final String message;

}
