package com.example.shiro.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response响应
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
@NoArgsConstructor
public class Response {
    private boolean status;
    private String info;

    public Response(boolean status) {
        this.status = status;
    }

    public Response(String info) {
        this.info = info;
    }
}
