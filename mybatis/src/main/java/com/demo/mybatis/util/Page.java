package com.demo.mybatis.util;

import lombok.Data;

/**
 * 项目: spring-boot
 * 时间: 2021/11/9 11:23
 *
 * @author HuangYu
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class Page {
    private long startIndex;
    private long endIndex;

    public Page() {
        this.startIndex = 0L;
        this.endIndex = 10L;
    }

    public Page(long currentPage, long pageSize) {
        currentPage = currentPage > 0L ? currentPage : 1L;
        pageSize = pageSize > 0L ? pageSize : 10L;
        this.startIndex = (currentPage - 1L) * pageSize;
        this.endIndex = currentPage * pageSize;
    }
}