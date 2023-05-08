package com.github.yizhen.common.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.yizhen.common.async.DemoAsyncManager;
import com.github.yizhen.framework.core.api.ApiResult;
import com.github.yizhen.framework.core.api.TypeReferenceApiResult;
import com.github.yizhen.framework.core.util.AsyncUtil;
import com.github.yizhen.framework.core.util.JacksonUtil;
import com.github.yizhen.framework.token.context.SecurityContextHolder;
import com.github.yizhen.framework.token.entiy.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private DemoAsyncManager demoAsyncManager;


    @GetMapping(value = "testAsync")
    public ApiResult<String> testAsync() {


        for (int i = 0; i < 20; i++) {
            LoginUser loginUser = new LoginUser();
            loginUser.setUserid(123L);
            loginUser.setUsername("tom");
            SecurityContextHolder.setLoginUser(loginUser);
            if (i == 6) {
                LoginUser loginUser1 = new LoginUser();
                loginUser1.setUserid(456L);
                loginUser1.setUsername("tony");
                SecurityContextHolder.setLoginUser(loginUser1);
            }
            log.info("parent====当前线程：{}，i={} ////////////  LoginUser={}", Thread.currentThread().getName(), i,SecurityContextHolder.getLoginUser());

            int finalI = i;
            AsyncUtil.asyncDeal(() -> {
                demoAsyncManager.testParentVal(finalI);
            });
            SecurityContextHolder.remove();

        }


        log.info("parent====当前线程{},异步请求完成，返回ok", Thread.currentThread().getName());


        return ApiResult.ok();
    }


    public static void main(String[] args) {
        String json = getList();
        ApiResult<List> listApiResult = JacksonUtil.parseObject(json, new TypeReferenceApiResult<>(List.class));
        ApiResult<List<String>> listApiResult1 = JacksonUtil.parseObject(json, new TypeReference<ApiResult<List<String>>>() {
        });
        System.out.println(listApiResult);
    }
}
