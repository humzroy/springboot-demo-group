package com.github.yizhen.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author yizhen
 * @date 2022/12/10 10:07
 **/

@SpringBootApplication(scanBasePackages = "com.github.yizhen")
public class BaseApplication {


    public static void main(String[] args) {

        SpringApplication.run(BaseApplication.class, args);
    }
}
