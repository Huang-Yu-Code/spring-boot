package com.demo.web.controller;

import com.demo.web.util.ResponseUtils;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("")
    public Object get(){
        Map<String,Object> map = new HashMap<>(16);
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        return ResponseUtils.success(200,map);
    }

    @PostMapping("")
    public Object insert(){
        return ResponseUtils.success(201,"success");
    }

    @PutMapping("")
    public Object update(){
        return ResponseUtils.success(200,"success");
    }

    @DeleteMapping("")
    public Object delete(){
        return ResponseUtils.success(200,"success");
    }
}
