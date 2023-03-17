package com.github.yizhen.demo.feign.client;

import com.github.yizhen.framework.core.api.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "feign-c")
public interface FeignCClient {


    @PostMapping("api/c/demo-c")
    ApiResult<String> demoC(@RequestBody String json);


}
