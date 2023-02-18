package com.github.yizhen.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yizhen.mybatis.dao.ISysUserMapper;
import com.github.yizhen.mybatis.entity.SysUser;
import com.github.yizhen.mybatis.service.ISysUserService;
import com.github.yizhen.framework.core.util.DateUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
  *  服务实现类
  *
 * @author wuhengzhen
 * @since 2023-02-18
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<ISysUserMapper, SysUser> implements ISysUserService {

    /**
     * 分页查询
     *
     * @param conditions
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.github.yizhen.mybatis.entity.SysUser>
     * @author wuhengzhen
     * @date 2023-02-18
     */
    @Override
    public Page<SysUser> getPage(SysUser conditions) {
        // 查询条件
        QueryWrapper<SysUser> queryWrapper = getQueryWrapper(conditions);
        // 排序
        formatOrder(queryWrapper, conditions.getSort(), conditions.getOrder());
        // 组装分页参数
        Page<SysUser> page = new Page<>(conditions.getPageNo(), conditions.getPageSize());
        return baseMapper.selectPage(page, queryWrapper);
    }

    /**
     * 列表查询
     *
     * @param conditions
     * @return java.util.List<com.github.yizhen.mybatis.entity.SysUser>
     * @author wuhengzhen
     * @date 2023-02-18
     */
    @Override
    public List<SysUser> getList(SysUser conditions) {
        // 查询条件
        QueryWrapper<SysUser> queryWrapper = getQueryWrapper(conditions);
        // 排序
        formatOrder(queryWrapper, conditions.getSort(), conditions.getOrder());
        return baseMapper.selectList(queryWrapper);
    }

    /**
     * 单条查询
     *
     * @param conditions
     * @return com.github.yizhen.mybatis.entity.SysUser
     * @author wuhengzhen
     * @date 2023-02-18
     */
    @Override
    public SysUser getOne(SysUser conditions) {
        // 查询条件
        QueryWrapper<SysUser> queryWrapper = getQueryWrapper(conditions);
        // 排序
        formatOrder(queryWrapper, conditions.getSort(), conditions.getOrder());
        return baseMapper.selectOne(queryWrapper);
    }

    /**
     * 统计
     *
     * @param conditions
     * @return java.lang.Integer
     * @author wuhengzhen
     * @date 2023-02-18
     */
    @Override
    public Long getCount(SysUser conditions) {
        // 查询条件
        QueryWrapper<SysUser> queryWrapper = getQueryWrapper(conditions);
        return baseMapper.selectCount(queryWrapper);
    }

    /**
     * 拼接查询条件
     *
     * @param conditions
     * @param conditions
     * @return com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<com.github.yizhen.mybatis.entity.SysUser>
     * @author wuhengzhen
     * @date 2023-02-18
     */
    private QueryWrapper<SysUser> getQueryWrapper(SysUser conditions) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<SysUser> lambda = queryWrapper.lambda();
        // 查询条件
        // 创建时间不为空
        if (ObjectUtils.isNotEmpty(conditions.getCreateTime())) {
            lambda.ge(SysUser::getCreateTime, DateUtil.getDayTime00(conditions.getCreateTime()));
            lambda.le(SysUser::getCreateTime, DateUtil.getDayTime59(conditions.getCreateTime()));
        }
        // 更新时间不为空
        if (ObjectUtils.isNotEmpty(conditions.getUpdateTime())) {
            lambda.ge(SysUser::getUpdateTime, DateUtil.getDayTime00(conditions.getUpdateTime()));
            lambda.le(SysUser::getUpdateTime, DateUtil.getDayTime59(conditions.getUpdateTime()));
        }
        return queryWrapper;
    }
}
