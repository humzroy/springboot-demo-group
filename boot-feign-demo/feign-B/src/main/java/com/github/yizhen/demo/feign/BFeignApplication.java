package com.github.yizhen.demo.feign;

import com.github.yizhen.framework.feign.annotation.EnableYiZhenFeignClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 *
 * @author yizhen
 * @date 2023/03/17 22:08
 **/
@Slf4j
@EnableYiZhenFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.github.yizhen")
public class BFeignApplication {

    public static void main(String[] args) {

        SpringApplication.run(BFeignApplication.class, args);
    }
}
