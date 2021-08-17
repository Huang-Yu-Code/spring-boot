package com.github.codingob.spring.boot.web.socket.message;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
@NoArgsConstructor
public class ResponseMessage {
    private String username;
    private String message;

    public ResponseMessage(String username, String message) {
        this.username = username;
        this.message = message;
    }
}
