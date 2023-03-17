package com.github.yizhen.demo.feign.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.yizhen.framework.core.api.ApiResult;
import com.github.yizhen.framework.core.constant.BaseConstant;
import com.github.yizhen.framework.core.util.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * C 服务的controller
 *
 * @author yizhen
 * @date 2023/03/17 22:16
 **/


@Slf4j
@RestController
@RequestMapping("api/c/")
public class CServerController {


    @PostMapping("demo-c")
    public ApiResult<String> demoC(@RequestBody String json) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        log.info("requestAttributes is null, {}", ObjectUtil.isNull(requestAttributes));
        log.info("header:{}", ServletUtils.getRequest().getHeader(BaseConstant.FeignHeader.AUTHENTICATION_TYPE));

        log.info("sever c , json:{}", json);
        return ApiResult.ok("获取成功", "c-succ");
    }

}
