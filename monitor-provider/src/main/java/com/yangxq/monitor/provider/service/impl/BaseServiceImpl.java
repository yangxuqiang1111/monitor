package com.yangxq.monitor.provider.service.impl;

import com.yangxq.monitor.dao.mysql.mapper.IBaseMapper;
import com.yangxq.monitor.provider.service.IBaseService;

/**
 * Created by Yangxq on 2016/8/26.
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {
    @Override
    public boolean insert(T t) {
        int result = getBaseMapper().insert(t);
        return result > 0 ? true : false;
    }

    public abstract IBaseMapper<T> getBaseMapper();

    @Override
    public T get(int id) {
        return getBaseMapper().selectByPrimaryKey(id);
    }
}
