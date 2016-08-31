package com.yangxq.monitor.provider.impl;

import com.yangxq.monitor.common.api.StatisticProvider;
import com.yangxq.monitor.common.model.StatisticsDataModel;
import com.yangxq.monitor.common.po.Statistics;
import com.yangxq.monitor.dao.mysql.mapper.IBaseMapper;
import com.yangxq.monitor.dao.mysql.mapper.StatisticsMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yangxq on 2016/8/29.
 */
public class StatisticProviderImpl extends BaseProviderImpl implements StatisticProvider {

    @Override
    public boolean insert(Statistics statistics) {
        return statisticService.insert(statistics);
    }

    @Override
    public StatisticsDataModel listByTime(int businessId, String  dateStr) {
        return statisticService.list(businessId, dateStr);
    }
}
