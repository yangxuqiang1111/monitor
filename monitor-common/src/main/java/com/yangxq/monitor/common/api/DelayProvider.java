package com.yangxq.monitor.common.api;

import com.yangxq.monitor.common.po.Delay;

/**
 * Created by Yangxq on 2016/8/26.
 * 耗时api
 */
public interface DelayProvider {

    /**
     * 插入数据
     * @param delay
     * @return
     */
    boolean insert(Delay delay);

}
