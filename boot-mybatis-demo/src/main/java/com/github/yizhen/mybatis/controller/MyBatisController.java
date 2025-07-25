package com.github.yizhen.mybatis.controller;

import com.github.yizhen.framework.core.api.ApiResult;
import com.github.yizhen.mybatis.entity.SysUser;
import com.github.yizhen.mybatis.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yizhen
 * @date 2025/07/25 22:04
 **/
@Slf4j
@RestController
@RequestMapping("mybatis")
public class MyBatisController {

    @Resource
    private ISysUserService service;

    @PostMapping("getPageBySql")
    public ApiResult<?> getPageBySql(@RequestBody SysUser conditions) {
        return ApiResult.ok(service.getPageBySql(conditions));
    }

    @PostMapping("getPageHelperBySql")
    public ApiResult<?> getPageHelperBySql(@RequestBody SysUser conditions) {
        return ApiResult.ok(service.getPageHelperBySql(conditions));
    }

}
