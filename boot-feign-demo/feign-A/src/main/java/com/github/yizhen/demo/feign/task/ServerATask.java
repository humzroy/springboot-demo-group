package com.github.yizhen.demo.feign.task;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.yizhen.demo.feign.client.FeignBClient;
import com.github.yizhen.framework.core.util.FeignResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Objects;

/**
 * @author yizhen
 * @date 2023/03/17 22:38
 **/

@Component
@Slf4j
public class ServerATask {

    @Autowired
    private FeignBClient bClient;


    //@Scheduled(cron = "*/30 * * * * ?")
    public void taskA() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "tom");
        jsonObject.put("age", 18);
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        log.info("[task]                     requestAttributes is null, {}",ObjectUtil.isNull(requestAttributes));
        log.info("[task]                     server A request B , start ... ");
        //String resp = FeignResponseUtil.get(bClient.demoB(jsonObject.toJSONString()));
        String resp = FeignResponseUtil.get(bClient.demoBAsync(jsonObject.toJSONString()));
        log.info("[task]                     server A request B , return resp:{}", resp);

    }


}
