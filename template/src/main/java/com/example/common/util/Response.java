package com.example.common.util;

import com.example.common.enums.ResponseCode;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 项目: minio
 * 时间: 2021/11/9 15:08
 * 统一响应工具类
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class Response {
    private Integer code;
    private String msg;
    private Object data;
    private LocalDateTime timestamp;

    private Response(){}

    /**
     * 响应
     * @param responseCode 状态码
     * @param data 数据
     * @param <T> 数据类型
     * @return 响应
     */
    private static <T> Response response(ResponseCode responseCode, T data) {
        Response response = new Response();
        response.setCode(responseCode.getCode());
        response.setMsg(responseCode.getMsg());
        response.setData(data);
        response.setTimestamp(LocalDateTime.now());
        return response;
    }

    /**
     * 成功响应
     * @param responseCode 状态码
     * @param data 数据
     * @param <T> 数据类型
     * @return 成功响应
     */
    public static <T> Response success(ResponseCode responseCode, T data) {
        return response(responseCode, data);
    }

    /**
     * 失败响应
     * @param responseCode 状态码
     * @return 失败响应
     */
    public static Response failure(ResponseCode responseCode) {
        return response(responseCode, null);
    }
}
