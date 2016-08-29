package com.yangxq.monitor.provider.service.impl;

import com.yangxq.monitor.common.po.Business;
import com.yangxq.monitor.dao.mysql.mapper.BusinessMapper;
import com.yangxq.monitor.dao.mysql.mapper.IBaseMapper;
import com.yangxq.monitor.provider.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2016/8/29.
 */
@Service
public class BusinessServiceImpl extends BaseServiceImpl<Business> implements BusinessService<Business> {
    @Resource
    private BusinessMapper businessMapper;
    @Override
    public IBaseMapper<Business> getBaseMapper() {
        return this.businessMapper;
    }
}
