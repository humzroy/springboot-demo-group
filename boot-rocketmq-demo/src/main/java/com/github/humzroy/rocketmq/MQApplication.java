package com.github.humzroy.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 入口
 *
 * @author wuhen
 * @date 2022/12/04 15:29
 **/

//@ComponentScan(basePackages = "com.github.humzroy.**")
@SpringBootApplication
public class MQApplication {

    public static void main(String[] args) {
        SpringApplication.run(MQApplication.class, args);
    }
}
