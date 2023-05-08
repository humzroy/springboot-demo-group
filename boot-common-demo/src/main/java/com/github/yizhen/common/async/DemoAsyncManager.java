package com.github.yizhen.common.async;

import com.github.yizhen.framework.token.context.SecurityContextHolder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 测试异步线程
 *
 * @author yizhen
 * @date 2023/05/08 21:29
 **/
@Slf4j
@Component
public class DemoAsyncManager {


    @SneakyThrows
    public void testParentVal(Integer val) {
        log.info("child====当前线程：{}，i={},LoginUser={}", Thread.currentThread().getName(), val,SecurityContextHolder.getLoginUser());

    }

}
