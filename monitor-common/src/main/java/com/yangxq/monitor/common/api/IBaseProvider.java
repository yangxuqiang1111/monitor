package com.yangxq.monitor.common.api;

/**
 * Created by Yangxq on 2016/8/26.
 */
public interface IBaseProvider<T> {
    /**
     * 插入数据
     * @param t
     * @return
     */
    public boolean insert(T t);
}
