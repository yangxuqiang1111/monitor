package com.yangxq.monitor.provider.service;

/**
 * Created by Yangxq on 2016/8/26.
 */
public interface IBaseService<T> {
    /**
     * 插入数据
     * @param t
     * @return
     */
    public boolean insert(T t);
}
