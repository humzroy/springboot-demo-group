package com.github.yizhen.demo.feign.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.yizhen.demo.feign.client.FeignBClient;
import com.github.yizhen.framework.core.api.ApiResult;
import com.github.yizhen.framework.core.constant.BaseConstant;
import com.github.yizhen.framework.core.util.FeignResponseUtil;
import com.github.yizhen.framework.core.util.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author wuhengzhen
 * @date 2023/03/18 12:25
 **/
@Slf4j
@RestController
@RequestMapping("api/a/")
public class ServerAController {


    @Autowired
    private FeignBClient bClient;


    @PostMapping(value = "test")
    public ApiResult<String> testServerA(@RequestBody String json) {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        log.info("requestAttributes is null, {}", ObjectUtil.isNull(requestAttributes));
        log.info("header:AUTHENTICATION_TYPE={}", ServletUtils.getRequest().getHeader(BaseConstant.FeignHeader.AUTHENTICATION_TYPE));
        log.info("header:FEIGN_SOURCE={}", ServletUtils.getRequest().getHeader("FEIGN_SOURCE"));

        String resp = FeignResponseUtil.get(bClient.demoBAsync(json));
        log.info("server a , request b and received resp is : {} ", resp);

        return ApiResult.ok("接收成功", "succ-a");

    }

}
