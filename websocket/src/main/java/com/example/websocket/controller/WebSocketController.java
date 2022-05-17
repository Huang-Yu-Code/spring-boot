package com.example.websocket.controller;

import com.example.websocket.message.RequestMessage;
import com.example.websocket.message.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Controller
@Slf4j
public class WebSocketController {
    @MessageMapping("/request")
    @SendTo("/topic/response")
    public ResponseMessage responseMessage(RequestMessage requestMessage){
        log.info(requestMessage.toString());
        return new ResponseMessage(requestMessage.getUsername(),requestMessage.getMessage());
    }
}
