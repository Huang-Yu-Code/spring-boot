package com.example.minio.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 项目: minio
 * 时间: 2022/3/24 23:33
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@AllArgsConstructor
@Getter
public enum ResponseCode {
    // 成功
    SUCCESS(200, "success"),
    // 失败
    FAILURE(400, "failure"),
    BIND_EXCEPTION(400, "接口参数错误"),
    // 异常
    SERVER_EXCEPTION(500, "服务器异常");

    private final int code;
    private final String msg;
}
