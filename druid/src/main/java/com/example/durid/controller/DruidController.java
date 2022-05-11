package com.example.durid.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目: Druid
 * 时间: 2022/5/11 18:53
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
public class DruidController {
    @GetMapping("/druid/stat")
    public Object druidStat(){
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
}
