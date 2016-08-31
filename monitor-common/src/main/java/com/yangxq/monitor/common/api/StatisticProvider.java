package com.yangxq.monitor.common.api;

import com.yangxq.monitor.common.model.StatisticsDataModel;
import com.yangxq.monitor.common.po.Statistics;

import java.util.List;

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

    /**
     *  根据业务id 和时间区间获取统计数据
     * @param businessId
     * @param dateStr
     * @return
     */
    StatisticsDataModel listByTime(int businessId,String dateStr);
}
