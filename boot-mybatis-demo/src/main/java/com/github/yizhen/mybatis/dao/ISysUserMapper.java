package com.github.yizhen.mybatis.dao;

import com.github.yizhen.mybatis.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sun.reflect.generics.tree.VoidDescriptor;

import java.util.List;

/**
  *  Mapper 接口
  *
 * @author wuhengzhen
 * @since 2023-02-18
 */
@Mapper
public interface ISysUserMapper extends BaseMapper<SysUser> {


    void saveBatch(@Param(value = "list") List<SysUser> userList);

}
