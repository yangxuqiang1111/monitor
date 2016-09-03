package com.yangxq.monitor.provider.service;

import java.util.List;

/**
 * Created by Yangxq on 2016/8/29.
 */
public interface BusinessService<T> extends IBaseService<T> {
    /**
     * 根据sysId 查询相关业务监控
     *
     * @param sysId
     * @return
     */
    List<T> listBySysId(int sysId);
}
