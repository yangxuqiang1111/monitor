package com.yangxq.monitor.common.api;

import com.yangxq.monitor.common.po.Statistics;

/**
 * Created by Yangxq on 2016/8/29.
 */
public interface StatisticProvider{
    /**
     * 插入数据
     * @param statistics
     * @return
     */
    boolean insert(Statistics statistics);

}
