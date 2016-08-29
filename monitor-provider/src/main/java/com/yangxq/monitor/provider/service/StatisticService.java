package com.yangxq.monitor.provider.service;

import com.yangxq.monitor.common.model.StatisticsDataModel;
import com.yangxq.monitor.common.po.Statistics;

import java.util.List;

/**
 * Created by Yangxq on 2016/8/29.
 */
public interface StatisticService<T> extends IBaseService<T> {
    /**
     *
     * @param businessId
     * @return
     */
   StatisticsDataModel list(int businessId, int end);
}
