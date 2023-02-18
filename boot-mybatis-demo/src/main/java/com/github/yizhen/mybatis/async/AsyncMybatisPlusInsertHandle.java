package com.github.yizhen.mybatis.async;

import cn.hutool.core.date.SystemClock;
import com.github.yizhen.mybatis.dao.ISysUserMapper;
import com.github.yizhen.mybatis.entity.SysUser;
import com.github.yizhen.mybatis.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author humzroy
 * @date 2023/02/18 21:40
 **/
@Slf4j
@Component
public class AsyncMybatisPlusInsertHandle {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysUserMapper sysUserMapper;


    /**
     * @param userList 数据list
     */
    @Async
    public void mybatisPlusBatchInsertAsync(List<SysUser> userList) {
        dealUserName(userList);
        long now = SystemClock.now();
        log.info("线程：{} 保存{}条数据 开始 now{}", Thread.currentThread().getName(), userList.size(), now);
        sysUserService.saveBatch(userList);
        log.info("线程：{} 保存{}条数据 结束 耗时：{}", Thread.currentThread().getName(), userList.size(), SystemClock.now() - now);

    }

    @Async
    public void mybatisBatchInsertAsync(List<SysUser> userList) {
        dealUserName(userList);
        long now = SystemClock.now();
        log.info("线程：{} 保存{}条数据 开始 now{}", Thread.currentThread().getName(), userList.size(), now);
        sysUserMapper.saveBatch(userList);
        log.info("线程：{} 保存{}条数据 结束 耗时：{}", Thread.currentThread().getName(), userList.size(), SystemClock.now() - now);


    }

    private void dealUserName(List<SysUser> userList) {
        userList.forEach(e-> e.setName(e.getName() + ":" + Thread.currentThread().getName()));
    }

}
