package com.demo.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目: spring-boot
 * 时间: 2021/10/22 0:39
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequestMapping("/json")
public class JsonController {

    @PostMapping("")
    public Object add(@RequestBody Map<String, Object> map) {
        try {
            URI uri = new URI("http://localhost");
            return ResponseEntity.created(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }


    @GetMapping("")
    public Object get() {
        Map<String, Object> map = new HashMap<>(16);
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        return null;
    }

    @PutMapping("")
    public Object update() {
        return null;
    }

    @DeleteMapping("")
    public Object delete() {
        return null;
    }
}
