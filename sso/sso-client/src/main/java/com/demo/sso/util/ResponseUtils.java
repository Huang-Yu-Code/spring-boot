package com.demo.sso.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目: Buddhism
 * 时间: 2021/11/15 9:36
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
public class ResponseUtils {
    private static final String STATUS = "status";
    private static final String DATA = "data";
    private static final String MSG = "msg";
    private static final String ERROR = "error";
    private static final String TIMESTAMP = "timestamp";

    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final String SERVER_ERROR = "服务器异常";

    private ResponseUtils() {
    }

    public static Map<String, Object> getBody(HttpStatus status) {
        Map<String, Object> response = new HashMap<>(4);
        response.put(STATUS, status.value());
        response.put(TIMESTAMP, new Timestamp(System.currentTimeMillis()));
        return response;
    }

    public static Map<String, Object> getBody(HttpStatus status, Object data) {
        Map<String, Object> response = getBody(status);
        response.put(MSG, SUCCESS);
        response.put(DATA, data);
        return response;
    }

    public static Map<String, Object> getBody(HttpStatus status, String error) {
        Map<String, Object> body = getBody(status);
        body.put(MSG, FAILURE);
        body.put(ERROR, error);
        return body;
    }

    public static ResponseEntity<Object> success(HttpStatus status, Object data) {
        Map<String, Object> body = getBody(status, data);
        return ResponseEntity.status(status).body(body);
    }

    public static ResponseEntity<Object> failure(HttpStatus status, String error) {
        Map<String, Object> body = getBody(status, error);
        return ResponseEntity.status(status).body(body);
    }

    public static ResponseEntity<Object> serverError() {
        return failure(HttpStatus.INTERNAL_SERVER_ERROR, SERVER_ERROR);
    }

    public static ResponseEntity<Object> clientError(String error) {
        return failure(HttpStatus.BAD_REQUEST, error);
    }
}
