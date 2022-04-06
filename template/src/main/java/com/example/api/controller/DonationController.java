package com.example.api.controller;

import com.example.api.entity.Donation;
import com.example.api.service.DonationService;
import com.example.api.vo.DonationVo;
import com.example.common.entity.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/5 17:41
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/donation")
public class DonationController {
    private final DonationService service;

    @GetMapping("/{id}")
    public Response<Donation> select(@PathVariable Long id) {
        return Response.success(service.select(id));
    }

    @GetMapping("")
    public Response<List<DonationVo>> selectList(Donation user) {
        return Response.success(service.selectList(user));
    }

    @PostMapping("")
    public Response<Void> insert(@RequestBody DonationVo entity) {
        service.insert(entity);
        return Response.success();
    }

    @PutMapping("")
    public Response<Void> update(@RequestBody DonationVo entity) {
        service.update(entity);
        return Response.success();
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return Response.success();
    }
}
