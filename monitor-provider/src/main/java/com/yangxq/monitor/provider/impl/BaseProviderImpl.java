package com.yangxq.monitor.provider.impl;

import com.yangxq.monitor.common.po.*;
import com.yangxq.monitor.provider.service.*;

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

    @Resource
    EmailService emailService;

    @Resource
    SysService<Sys> sysService;

    

}
