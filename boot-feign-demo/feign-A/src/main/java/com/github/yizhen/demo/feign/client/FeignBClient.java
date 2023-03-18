package com.github.yizhen.demo.feign.client;

import com.github.yizhen.framework.core.api.ApiResult;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "feign-b")
public interface FeignBClient {


    @PostMapping(value = "api/b/demo-b")
    ApiResult<String> demoB(@RequestBody String json);


    @PostMapping(value = "api/b/demo-b-async")
        //, headers = {"AUTHENTICATION_TYPE=NO_AUTHENTICATION", "FEIGN_SOURCE=A}"}
    ApiResult<String> demoBAsync(@RequestBody String json);

}
