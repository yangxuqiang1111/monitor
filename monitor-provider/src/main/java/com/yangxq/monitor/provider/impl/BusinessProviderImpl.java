package com.yangxq.monitor.provider.impl;

import com.yangxq.monitor.common.api.BusinessProvider;
import com.yangxq.monitor.common.po.Business;
import com.yangxq.monitor.dao.mysql.mapper.BusinessMapper;
import com.yangxq.monitor.dao.mysql.mapper.IBaseMapper;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2016/8/26.
 * 监控业务提供者
 */
public class BusinessProviderImpl extends BaseProviderImpl<Business> implements BusinessProvider<Business> {
    @Resource
    private BusinessMapper businessMapper;
    @Override
    public IBaseMapper<Business> getBaseMapper() {
        return this.businessMapper;
    }
}
