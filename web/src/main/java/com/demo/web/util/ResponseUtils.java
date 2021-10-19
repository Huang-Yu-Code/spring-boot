package com.demo.web.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
public class ResponseUtils extends HashMap<String, String> {

    public static Map<String, String> get(){
        return new ResponseUtils();
    }

}
