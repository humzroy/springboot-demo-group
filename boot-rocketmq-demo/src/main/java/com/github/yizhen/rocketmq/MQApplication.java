package com.github.yizhen.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 入口
 *
 * @author wuhen
 * @date 2022/12/04 15:29
 **/

//@ComponentScan(basePackages = "com.github.yizhen.**")
@SpringBootApplication
public class MQApplication {

    public static void main(String[] args) {
        SpringApplication.run(MQApplication.class, args);
    }
}
