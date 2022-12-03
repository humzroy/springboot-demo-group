package com.github.humzroy.docker;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
@RestController
public class DockerApplication {

    public static void main(String[] args) {

        SpringApplication.run(DockerApplication.class, args);
    }


    @GetMapping("hello")
    public String hello() {
        return "hello docker";
    }

}
