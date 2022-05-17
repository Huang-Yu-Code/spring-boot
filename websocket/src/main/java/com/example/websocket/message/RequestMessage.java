package com.example.websocket.message;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
@NoArgsConstructor
public class RequestMessage {
    private String username;
    private String message;

    public RequestMessage(String username, String message) {
        this.username = username;
        this.message = message;
    }
}
