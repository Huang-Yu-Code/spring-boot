package com.demo.web.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目: spring-boot
 * 时间: 2021/10/27 0:23
 * Response工具类
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
public class ResponseUtils extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String CODE = "code";
    private static final String MSG = "msg";
    private static final String DATA = "data";
    private static final String ERROR = "error";

    public static ResponseUtils getResponse() {
        return new ResponseUtils();
    }

    public static ResponseUtils success(int code, String msg) {
        return ResponseUtils.getResponse().putCode(code).putMsg(msg);
    }

    public static ResponseUtils success(int code, Object data) {
        return ResponseUtils.getResponse().putCode(code).putData(data);
    }

    public static ResponseUtils failure(int code, String error) {
        return ResponseUtils.getResponse().putCode(code).putError(error);
    }

    public static ResponseUtils failure(String error) {
        return ResponseUtils.failure(400, error);
    }

    public ResponseUtils putInfo(Map<String, Object> info) {
        for (String key : info.keySet()) {
            this.putInfo(key, info.get(key));
        }
        return this;
    }

    public ResponseUtils putInfo(String key, Object value) {
        this.put(key, value);
        return this;
    }

    private ResponseUtils putCode(int code) {
        return this.putInfo(CODE, code);
    }

    private ResponseUtils putMsg(String msg) {
        return this.putInfo(MSG, msg);
    }

    private ResponseUtils putData(Object data) {
        return this.putInfo(DATA, data);
    }

    private ResponseUtils putError(String error) {
        return this.putInfo(ERROR, error);
    }
}
