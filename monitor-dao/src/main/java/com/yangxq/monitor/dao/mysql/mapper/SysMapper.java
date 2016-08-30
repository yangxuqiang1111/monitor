package com.yangxq.monitor.dao.mysql.mapper;

import com.yangxq.monitor.common.po.Sys;

import java.util.List;

public interface SysMapper extends IBaseMapper<Sys>{
    /**
     * 列出所有系统
     * @return
     */
    List<Sys> list();

//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Sys record);
//
//    int insertSelective(Sys record);
//
//    Sys selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Sys record);
//
//    int updateByPrimaryKey(Sys record);
}