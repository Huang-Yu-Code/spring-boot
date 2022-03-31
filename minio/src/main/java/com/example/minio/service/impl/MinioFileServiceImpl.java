package com.example.minio.service.impl;

import com.example.common.exception.CommonException;
import com.example.common.util.MinioUtils;
import com.example.minio.entity.MinioFile;
import com.example.minio.mapper.MinioFileMapper;
import com.example.minio.service.MinioFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * 项目: minio
 * 时间: 2022/3/24 23:19
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MinioFileServiceImpl implements MinioFileService {
    private final MinioUtils minioUtils;
    private final MinioFileMapper minioFileMapper;

    @Override
    public void upload(MinioFile minioFile) {
        String url = minioUtils.upload(minioFile.getFile());
        minioFile.setUrl(url);
        try {
            minioFileMapper.insert(minioFile);
        } catch (Exception e) {
            log.error("ERROR:", e);
            minioUtils.delete(url);
            throw new CommonException("上传失败");
        }
    }

    @Override
    public void delete(Long id) {
        log.info("id:{}",id);
        MinioFile minioFile = minioFileMapper.select(id);
        log.info("minioFile:{}",minioFile);
        Assert.notNull(minioFile,"资源文件不存在");
        String url = minioFile.getUrl();
        minioFileMapper.delete(id);
        minioUtils.delete(url);
    }
}
