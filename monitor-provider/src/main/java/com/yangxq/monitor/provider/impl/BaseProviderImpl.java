package com.yangxq.monitor.provider.impl;

import com.yangxq.monitor.common.po.*;
import com.yangxq.monitor.provider.service.BusinessService;
import com.yangxq.monitor.provider.service.EmailService;
import com.yangxq.monitor.provider.service.StatisticService;
import com.yangxq.monitor.provider.service.SysService;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2016/8/29.
 */
public abstract class BaseProviderImpl {

    @Resource
     BusinessService<Business> businessService;

    @Resource
    StatisticService<Statistics> statisticService;


    @Resource
    EmailService emailService;

    @Resource
    SysService<Sys> sysService;

    

}
