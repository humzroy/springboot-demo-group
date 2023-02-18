package com.github.yizhen.rocketmq.controller;

import com.github.yizhen.framework.rocketmq.dto.MessageRequest;
import com.github.yizhen.framework.rocketmq.dto.RocketMQDelayLevelMapping;
import com.github.yizhen.framework.rocketmq.dto.RocketMQDelayTimeMapping;
import com.github.yizhen.framework.rocketmq.helper.RocketMQHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wuhen
 * @date 2022/12/04 15:31
 **/

@RestController
@Slf4j
public class MQController {

    @Autowired
    private RocketMQHelper rocketMQHelper;

    @GetMapping("sendMq")
    public String sendMq() {
        SendResult sendResult = rocketMQHelper.syncSend(MessageRequest.builder()
                .topic("test-topic")
                .tag("tag-a")
                .body("hello rocketmq~")
                .level(RocketMQDelayTimeMapping.NO_DELAY.getLevel())
                .build());
        return sendResult.getMsgId();
    }
}
