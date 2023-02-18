package com.github.yizhen.mybatis.service;

//import com.github.yizhen.framework.mybatis.base.BaseService;
import com.github.yizhen.framework.datasource.base.BaseService;
import com.github.yizhen.mybatis.entity.SysUser;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yizhen.framework.core.enums.DeleteEnums;

import java.util.List;

/**
  *  服务类
  *
 * @author wuhengzhen
 * @since 2023-02-18
 */
public interface ISysUserService extends BaseService<SysUser> {

     /**
      * 分页查询
      *
      * @param conditions
      * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.github.yizhen.mybatis.entity.SysUser>
      * @author wuhengzhen
      * @date 2023-02-18
      */
     Page<SysUser> getPage(SysUser conditions);

     /**
      * 列表查询
      *
      * @param conditions
      * @return java.util.List<com.github.yizhen.mybatis.entity.SysUser>
      * @author wuhengzhen
      * @date 2023-02-18
      */
     List<SysUser> getList(SysUser conditions);

    /**
     * 单条查询
     *
     * @param conditions
     * @return com.github.yizhen.mybatis.entity.SysUser
     * @author wuhengzhen
     * @date 2023-02-18
     */
    SysUser getOne(SysUser conditions);

    /**
     * 统计
     *
     * @param conditions
     * @return java.lang.Integer
     * @author wuhengzhen
     * @date 2023-02-18
     */
    Long getCount(SysUser conditions);

}
