package com.example.common.exception;

import com.example.common.enums.StatusCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 项目: template
 * 时间: 2021/11/9 15:08
 * 通用异常
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Getter
@Setter
public class CommonException extends RuntimeException {
    private final StatusCode statusCode;

    public CommonException(StatusCode statusCode) {
        super(statusCode.getMsg());
        this.statusCode = statusCode;

    }
}
