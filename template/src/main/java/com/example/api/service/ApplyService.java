package com.example.api.service;

import com.example.api.entity.Apply;
import com.example.api.vo.ApplyVo;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/5 17:40
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface ApplyService {

    ApplyVo select(Long id);

    List<ApplyVo> selectList(Apply entity);

    void insert(ApplyVo entity);

    void update(ApplyVo entity);

    void delete(Long id);
}
