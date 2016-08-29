package com.yangxq.monitor.provider.impl;

import com.yangxq.monitor.common.po.Business;
import com.yangxq.monitor.common.po.Delay;
import com.yangxq.monitor.common.po.Statistics;
import com.yangxq.monitor.common.po.Transfer;
import com.yangxq.monitor.provider.service.BusinessService;
import com.yangxq.monitor.provider.service.DelayService;
import com.yangxq.monitor.provider.service.StatisticService;
import com.yangxq.monitor.provider.service.TransferService;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2016/8/29.
 */
public abstract class BaseProviderImpl {

    @Resource
     BusinessService<Business> businessService;
    @Resource
    DelayService<Delay> delayService;
    @Resource
    StatisticService<Statistics> statisticService;

    @Resource
    TransferService<Transfer> transferService;

}
