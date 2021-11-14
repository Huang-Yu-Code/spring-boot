package com.demo.jwt.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目: spring-boot
 * 时间: 2021/11/10 11:08
 *
 * @author HuangYu
 * @version 1.0.0
 * @since JDK1.8
 */
public class ResponseUtils implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String CODE = "code";
    private static final String MSG = "msg";
    private static final String DATA = "data";
    private static final String ERROR = "error";
    private static final String TIMESTAMP = "timestamp";

    public static Map<String, Object> getResponse(int code, String msg, Object data) {
        Map<String, Object> response = new HashMap<>(3);
        response.put(CODE, code);
        response.put(MSG, msg);
        response.put(TIMESTAMP,new Timestamp(System.currentTimeMillis()));
        if (data != null) {
            response.put(DATA, data);
        }
        return response;
    }

    public static Map<String, Object> getResponse(int code, String error) {
        Map<String, Object> response = new HashMap<>(2);
        response.put(CODE, code);
        response.put(ERROR, error);
        response.put(TIMESTAMP,new Timestamp(System.currentTimeMillis()));
        return response;
    }

    public static ResponseEntity<Object> success(int code, String msg, Object data) {
        Map<String, Object> response = getResponse(code, msg, data);
        return ResponseEntity.status(code).body(response);
    }

    public static ResponseEntity<Object> success(int code, Object data) {
        return success(code, "OK", data);
    }

    public static ResponseEntity<Object> success(Object data) {
        return success(200, "OK", data);
    }

    public static ResponseEntity<Object> success() {
        return success(null);
    }

    public static ResponseEntity<Object> failure(int code, String error) {
        Map<String, Object> response = getResponse(code, error);
        return ResponseEntity.status(code).body(response);
    }

    public static ResponseEntity<Object> failure() {
        int code = 500;
        String error = "服务器异常";
        return failure(code, error);
    }

    public static ResponseEntity<Object> failure(String error) {
        return failure(400, error);
    }
}
