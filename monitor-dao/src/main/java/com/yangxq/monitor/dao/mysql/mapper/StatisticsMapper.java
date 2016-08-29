package com.yangxq.monitor.dao.mysql.mapper;

import com.yangxq.monitor.common.po.Statistics;

import java.util.List;

public interface StatisticsMapper extends IBaseMapper<Statistics>{
    List<Statistics> list(int businessId, int begTime, int endTime);
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Statistics record);
//
//    int insertSelective(Statistics record);
//
//    Statistics selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Statistics record);
//
//    int updateByPrimaryKey(Statistics record);
}