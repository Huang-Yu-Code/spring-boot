package com.example.common.entity;

import com.example.common.enums.StatusCode;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 项目: template
 * 时间: 2021/11/9 15:08
 * 统一响应工具类
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class Response<T> {
    private Integer code;
    private String message;
    private T data;
    private LocalDateTime time;

    private Response() {
    }

    /**
     * 响应
     *
     * @param statusCode 状态码
     * @param data       数据
     * @param <T>        数据类型
     * @return 响应
     */
    public static <T> Response<T> response(StatusCode statusCode, T data) {
        Response<T> response = new Response<>();
        response.setCode(statusCode.getCode());
        response.setMessage(statusCode.getMessage());
        response.setData(data);
        response.setTime(LocalDateTime.now());
        return response;
    }

    /**
     * 成功响应
     *
     * @param data 数据
     * @param <T>  数据类型
     * @return 成功响应
     */
    public static <T> Response<T> success(T data) {
        return response(StatusCode.SUCCESS, data);
    }

    /**
     * 成功响应
     *
     * @return 成功响应
     */
    public static Response<Void> success() {
        return response(StatusCode.SUCCESS, null);
    }

    /**
     * 失败响应
     *
     * @param statusCode 状态码
     * @return 失败响应
     */
    public static Response<Void> failure(StatusCode statusCode) {
        return response(statusCode, null);
    }
}
