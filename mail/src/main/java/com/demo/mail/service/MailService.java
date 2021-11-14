package com.demo.mail.service;

import java.io.File;
import java.util.Map;

/**
 * 项目: spring-boot
 * 时间: 2021/11/14 20:59
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
public interface MailService {
    /**
     * 发送邮箱
     *
     * @param email   邮箱
     * @param subject 主题
     * @param text    内容
     */
    void sendText(String email, String subject, String text);

    /**
     * 发送邮箱
     *
     * @param email   邮箱
     * @param subject 主题
     * @param html    内容
     * @param files   内联附件
     */
    void sendHtml(String email, String subject, String html, Map<String, File> files);

    /**
     * 发送邮箱
     *
     * @param email   邮箱
     * @param subject 主题
     * @param text    内容
     * @param files    附件
     */
    void sendFile(String email, String subject, String text, Map<String, File> files);
}
