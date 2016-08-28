package com.yangxq.monitor.provider.impl;

import com.yangxq.monitor.common.api.IBaseProvider;
import com.yangxq.monitor.dao.mysql.mapper.IBaseMapper;

/**
 * Created by Yangxq on 2016/8/26.
 */
public abstract class BaseProviderImpl<T> implements IBaseProvider<T> {
    @Override
    public boolean insert(T t) {
        int result = getBaseMapper().insert(t);
        return result > 0 ? true : false;
    }

    public abstract IBaseMapper<T> getBaseMapper();
}
