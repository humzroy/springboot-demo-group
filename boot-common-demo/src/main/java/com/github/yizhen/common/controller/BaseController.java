package com.github.yizhen.common.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.yizhen.framework.core.api.ApiResult;
import com.github.yizhen.framework.core.api.TypeReferenceApiResult;
import com.github.yizhen.framework.core.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yizhen
 * @date 2022/12/10 10:07
 **/
@RestController
@Slf4j
public class BaseController {


    @GetMapping("testJacksonType")
    public ApiResult<?> testJacksonType() {

        return ApiResult.ok();


    }


    private static String getList() {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            list.add("i" + i);
        }
        return JacksonUtil.toJsonString(ApiResult.ok(list));
    }

    public static void main(String[] args) {
        String json = getList();
        ApiResult<List> listApiResult = JacksonUtil.parseObject(json, new TypeReferenceApiResult<>(List.class));
        ApiResult<List<String>> listApiResult1 = JacksonUtil.parseObject(json, new TypeReference<ApiResult<List<String>>>() {
        });
        System.out.println(listApiResult);
    }
}
