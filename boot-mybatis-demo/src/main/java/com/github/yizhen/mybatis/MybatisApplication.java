package com.github.yizhen.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * mybatis测试项目
 *
 * @author humzroy
 * @date 2023/02/18 21:11
 **/


@SpringBootApplication(scanBasePackages = "com.github.yizhen.**")
//@ComponentScan("com.github.yizhen.**")
public class MybatisApplication {

    public static void main(String[] args) {

        SpringApplication.run(MybatisApplication.class, args);
    }
}
