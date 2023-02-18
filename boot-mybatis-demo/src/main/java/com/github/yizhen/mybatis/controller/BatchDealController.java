package com.github.yizhen.mybatis.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import com.github.yizhen.framework.core.api.ApiResult;
import com.github.yizhen.mybatis.async.AsyncMybatisPlusInsertHandle;
import com.github.yizhen.mybatis.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humzroy
 * @date 2023/02/18 21:35
 **/
@Slf4j
@RestController
@RequestMapping("batch")
public class BatchDealController {

    @Autowired
    private AsyncMybatisPlusInsertHandle asyncMybatisPlusInsertHandle;


    @GetMapping("mybatisPlusBatchInsert")
    public ApiResult<?> mybatisPlusBatchInsert() {
        int dataSize = 100100;
        List<SysUser> userList = getUserList(dataSize);
        // 拆分
        List<List<SysUser>> split = CollUtil.split(userList, 10000);
        //
        log.info("获取了{}条数据，拆分为{}个批次，开始异步调用。。。", dataSize, split.size());
        split.forEach(list -> asyncMybatisPlusInsertHandle.mybatisPlusBatchInsertAsync(list));

        log.info("{}条数据入库方法执行完成。。。", dataSize);
        return ApiResult.ok(dataSize + "条数据入库方法执行完成");

    }

    @GetMapping("mybatisBatchInsert")
    public ApiResult<?> mybatisBatchInsert() {
        int dataSize = 100100;
        List<SysUser> userList = getUserList(dataSize);
        // 拆分
        List<List<SysUser>> split = CollUtil.split(userList, 10000);
        //
        log.info("mybatis   获取了{}条数据，拆分为{}个批次，开始异步调用。。。", dataSize, split.size());
        split.forEach(list -> asyncMybatisPlusInsertHandle.mybatisBatchInsertAsync(list));

        log.info("mybatis   {}条数据入库方法执行完成。。。", dataSize);
        return ApiResult.ok(dataSize + "条数据入库方法执行完成 mybatis");

    }


    /**
     * 批量生产用户数据
     *
     * @param size 自己决定多少条
     * @return
     */
    public List<SysUser> getUserList(int size) {
        List<SysUser> list = new ArrayList<>();
        // 循环批量添加size条用户数据
        for (int i = 0; i < size; i++) {
            SysUser user = new SysUser();
            user.setName("x_" + i + 1);
            user.setPhone(Convert.toStr(i));

            list.add(user);
        }
        return list;
    }
}
