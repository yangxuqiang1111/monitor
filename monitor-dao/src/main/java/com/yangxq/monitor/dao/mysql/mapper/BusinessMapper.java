package com.yangxq.monitor.dao.mysql.mapper;

import com.yangxq.monitor.common.po.Business;

import java.util.List;

public interface BusinessMapper extends IBaseMapper<Business>{
    /**
     * 根据sysId 查询业务
     * @param sysId
     * @return
     */
    List<Business> listBySysId(int sysId);
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Business record);
//
//    int insertSelective(Business record);
//
//    Business selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Business record);
//
//    int updateByPrimaryKey(Business record);
}