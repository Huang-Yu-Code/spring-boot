package com.example.system.entity;

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
public class Response {
    private Integer code;
    private String message;
    private Object data;
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
    private static <T> Response response(StatusCode statusCode, T data) {
        Response response = new Response();
        response.setCode(statusCode.getCode());
        response.setMessage(statusCode.getMessage());
        response.setData(data);
        response.setTime(LocalDateTime.now());
        return response;
    }

    /**
     * 成功响应
     *
     * @param statusCode 状态码
     * @param data       数据
     * @param <T>        数据类型
     * @return 成功响应
     */
    public static <T> Response success(StatusCode statusCode, T data) {
        return response(statusCode, data);
    }

    /**
     * 成功响应
     *
     * @param data 数据
     * @param <T>  数据类型
     * @return 成功响应
     */
    public static <T> Response success(T data) {
        return response(StatusCode.SUCCESS, data);
    }

    /**
     * 成功响应
     *
     * @return 成功响应
     */
    public static Response success() {
        return response(StatusCode.SUCCESS, null);
    }

    /**
     * 失败响应
     *
     * @param statusCode 状态码
     * @return 失败响应
     */
    public static Response failure(StatusCode statusCode) {
        return response(statusCode, null);
    }
}
