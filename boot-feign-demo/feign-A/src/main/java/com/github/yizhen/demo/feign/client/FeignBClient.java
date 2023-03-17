package com.github.yizhen.demo.feign.client;

import com.github.yizhen.framework.core.api.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "feign-b")
public interface FeignBClient {


    @PostMapping("api/b/demo-b")
    ApiResult<String> demoB(@RequestBody String json);


    @PostMapping("api/b/demo-b-async")
    ApiResult<String> demoBAsync(@RequestBody String json);

}
