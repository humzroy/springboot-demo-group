package com.github.yizhen.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author wuhen
 * @date 2022/12/04 15:34
 **/

@Component
@Slf4j
@RocketMQMessageListener(topic = "test-topic", consumerGroup = "docker-group")
public class CommonConsumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String message) {
        log.info("CommonConsumer  收到消息:{}", message);
    }
}
