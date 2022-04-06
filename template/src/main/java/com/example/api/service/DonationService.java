package com.example.api.service;

import com.example.api.entity.Donation;
import com.example.api.vo.DonationVo;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/5 17:42
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface DonationService {

    DonationVo select(Long id);

    List<DonationVo> selectList(Donation entity);

    void insert(DonationVo entity);

    void update(DonationVo entity);

    void delete(Long id);
}
