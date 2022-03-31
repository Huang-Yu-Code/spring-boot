package com.example.minio.mapper;

import com.example.minio.entity.MinioFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目: minio
 * 时间: 2022/3/25 3:16
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface MinioFileMapper {
    MinioFile select(@Param("id") Long id);

    List<MinioFile> selectAll(MinioFile minioFile);

    int insert(MinioFile minioFile);

    int update(MinioFile minioFile);

    int delete(@Param("id")Long id);
}
