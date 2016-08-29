package com.yangxq.monitor.provider.service.impl;

import com.yangxq.monitor.common.po.Statistics;
import com.yangxq.monitor.dao.mysql.mapper.IBaseMapper;
import com.yangxq.monitor.dao.mysql.mapper.StatisticsMapper;
import com.yangxq.monitor.provider.service.StatisticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2016/8/29.
 */
@Service
public class StatisticServiceImpl extends BaseServiceImpl<Statistics> implements StatisticService<Statistics> {
    @Resource
    private StatisticsMapper statisticsMapper;
    @Override
    public IBaseMapper<Statistics> getBaseMapper() {
        return this.statisticsMapper;
    }
}
