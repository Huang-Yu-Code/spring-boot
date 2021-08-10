package com.demo.web.service;

import com.demo.web.util.CodeUtils;
import com.demo.web.util.DownloadUtils;
import com.demo.web.util.UploadUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;

/**
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
public class WebService {

    /**
     * 获取验证码
     *
     * @param session   session
     * @param timestamp 时间戳
     * @return 验证码图片字节数组
     */
    public byte[] code(HttpSession session, long timestamp) {
        long time = System.currentTimeMillis() - timestamp;
        if (time > 0 && time < CodeUtils.TIMEOUT) {
            String code = CodeUtils.getCode(4);
            session.setAttribute("timestamp", timestamp);
            session.setAttribute("code", code);
            return CodeUtils.getImage(200, 30, code);
        }
        return null;
    }

    /**
     * 文件上传
     *
     * @param file 文件
     * @param path 保存路径
     */
    public void upload(CommonsMultipartFile file, String path) {
        UploadUtils.save(file, path);
    }

    /**
     * 文件下载
     *
     * @param file 文件名
     * @return 文件字节数组
     */
    public byte[] download(String file) {
        return DownloadUtils.downloadForClassResource(file);
    }

}
