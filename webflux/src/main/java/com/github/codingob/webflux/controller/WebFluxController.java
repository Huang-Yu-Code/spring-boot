package com.github.codingob.webflux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

/**
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Controller
public class WebFluxController {
    @GetMapping("/")
    @ResponseBody
    public Mono<String> index(){
        return Mono.just("index");
    }
}
