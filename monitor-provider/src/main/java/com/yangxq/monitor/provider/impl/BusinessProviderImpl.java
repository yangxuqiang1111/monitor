package com.yangxq.monitor.provider.impl;

import com.yangxq.monitor.common.api.BusinessProvider;
import com.yangxq.monitor.common.po.Business;

/**
 * Created by Yangxq on 2016/8/26.
 * 监控业务提供者
 */
public class BusinessProviderImpl extends BaseProviderImpl implements BusinessProvider {


    @Override
    public boolean insert(Business business) {
       return businessService.insert(business);
    }

    @Override
    public Business get(int id) {
        return businessService.get(id);
    }
}
