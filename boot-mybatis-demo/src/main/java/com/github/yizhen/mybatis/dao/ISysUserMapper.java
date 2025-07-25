package com.github.yizhen.mybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yizhen.mybatis.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author wuhengzhen
 * @since 2023-02-18
 */
@Mapper
public interface ISysUserMapper extends BaseMapper<SysUser> {


    void saveBatch(@Param(value = "list") List<SysUser> userList);

    Page<SysUser> getPageBySql(Page<SysUser> page, @Param(value = "conditions") SysUser conditions);

    List<SysUser> getPageHelperBySql(@Param(value = "conditions") SysUser conditions);
}
