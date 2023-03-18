package com.github.yizhen.demo.feign.controller;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.yizhen.demo.feign.client.FeignCClient;
import com.github.yizhen.framework.core.api.ApiResult;
import com.github.yizhen.framework.core.constant.BaseConstant;
import com.github.yizhen.framework.core.util.AsyncUtil;
import com.github.yizhen.framework.core.util.FeignResponseUtil;
import com.github.yizhen.framework.core.util.ServletUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * B 服务的controller
 *
 * @author yizhen
 * @date 2023/03/17 22:33
 **/
@Slf4j
@RestController
@RequestMapping("api/b/")
public class BServerController {

    @Autowired
    private FeignCClient cClient;

    @PostMapping("demo-b")
    public ApiResult<String> demoB(@RequestBody String json) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        log.info("requestAttributes is null, {}", ObjectUtil.isNull(requestAttributes));
        log.info("server b , json:{}", json);
        log.info("server b , start request c ....");
        String resp = FeignResponseUtil.get(cClient.demoC(json));
        log.info("server b , end request c , return resp:{}", resp);
        return ApiResult.ok("获取成功", resp);
    }

    @SneakyThrows
    @PostMapping("demo-b-async")
    public ApiResult<String> demoBAsync(@RequestBody String json) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        log.info("requestAttributes is null, {}", ObjectUtil.isNull(requestAttributes));
        log.info("header:AUTHENTICATION_TYPE={}", ServletUtils.getRequest().getHeader(BaseConstant.FeignHeader.AUTHENTICATION_TYPE));
        log.info("header:FEIGN_SOURCE={}", ServletUtils.getRequest().getHeader("FEIGN_SOURCE"));
        RequestContextHolder.setRequestAttributes(requestAttributes);
        log.info("server b , json:{}", json);
        log.info("server b , start request c ....");
        // 异步调用
        AsyncUtil.asyncDeal(() -> cClient.demoC(json));

        // ThreadUtil.execAsync(() -> cClient.demoC(json));
        log.info("server b , end request c ");
        return ApiResult.ok("获取成功", "b-async-succ");
    }


}
