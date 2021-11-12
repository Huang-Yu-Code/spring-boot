package com.demo.web.service;

import com.demo.web.entity.File;
import com.demo.web.properties.FileProperties;
import com.demo.web.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 项目: spring-boot
 * 时间: 2021/10/20 14:13
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@Slf4j
public class FileService {
    private final FileProperties fileProperties;

    public FileService(FileProperties fileProperties) {
        this.fileProperties = fileProperties;
    }

    public File addFile(File file, MultipartFile multipartFile) {
        log.info("{}", file);
        log.info("{}", multipartFile);
        Assert.isTrue(multipartFile.getSize()>0,"文件为空");
        String filename = multipartFile.getOriginalFilename();
        Assert.notNull(filename, "文件名为空");
        file.setName(filename);
        file.setFormat(FileUtils.getFormat(filename));
        file.setSize(multipartFile.getSize());
        String location = fileProperties.getLocation();
        log.info(location);
        filename = FileUtils.save(multipartFile, location);
        file.setUrl(FileUtils.rename(filename));
        return file;
    }

    public File getFile(long id) {
        return null;
    }

    public File getFiles() {
        return null;
    }

    public File deleteFile(long id) {
        return null;
    }

}
