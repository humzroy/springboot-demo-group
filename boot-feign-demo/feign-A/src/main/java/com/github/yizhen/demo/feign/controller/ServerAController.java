package com.github.yizhen.demo.feign.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.yizhen.demo.feign.client.FeignBClient;
import com.github.yizhen.demo.feign.model.FileUploadModel;
import com.github.yizhen.framework.core.api.ApiResult;
import com.github.yizhen.framework.core.constant.BaseConstant;
import com.github.yizhen.framework.core.util.FeignResponseUtil;
import com.github.yizhen.framework.core.util.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wuhengzhen
 * @date 2023/03/18 12:25
 **/
@Slf4j
@RestController
@RequestMapping("api/a/")
public class ServerAController {


    //@Autowired
    //private FeignBClient bClient;
    //
    //
    //@PostMapping(value = "test")
    //public ApiResult<String> testServerA(@RequestBody String json) {
    //
    //    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    //    log.info("requestAttributes is null, {}", ObjectUtil.isNull(requestAttributes));
    //    log.info("header:AUTHENTICATION_TYPE={}", ServletUtils.getRequest().getHeader(BaseConstant.FeignHeader.AUTHENTICATION_TYPE));
    //    log.info("header:FEIGN_SOURCE={}", ServletUtils.getRequest().getHeader("FEIGN_SOURCE"));
    //
    //    String resp = FeignResponseUtil.get(bClient.demoBAsync(json));
    //    log.info("server a , request b and received resp is : {} ", resp);
    //
    //    return ApiResult.ok("接收成功", "succ-a");
    //
    //}

    @GetMapping(value = "testLimit")
    public ApiResult<String> testLimit() {
        log.info("test limit...");
        return ApiResult.ok("testLimit");
    }

    @PostMapping("testFile")
    public ApiResult<String> testFile(FileUploadModel fileParam, @RequestPart("file") MultipartFile file) {
        log.info(fileParam.toString());
        log.info("file name is {}", file.getOriginalFilename());
        log.info("file size is {}", file.getSize());
        log.info("file contentType is {}", file.getContentType());
        return ApiResult.ok("testFile");
    }

}
