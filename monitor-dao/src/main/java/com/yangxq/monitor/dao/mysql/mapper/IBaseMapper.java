package com.yangxq.monitor.dao.mysql.mapper;

import com.yangxq.monitor.common.po.Delay;

/**
 * Created by Yangxq on 2016/8/26.
 */
public interface IBaseMapper<T> {
    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(Delay record);
}
