package com.yangxq.monitor.provider.impl;

import com.yangxq.monitor.common.api.DelayProvider;
import com.yangxq.monitor.common.po.Delay;
import com.yangxq.monitor.dao.mysql.mapper.DelayMapper;
import com.yangxq.monitor.dao.mysql.mapper.IBaseMapper;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2016/8/26.
 * 耗时监控服务
 */

public class DelayProviderImpl extends BaseImpl<Delay> implements DelayProvider<Delay> {
    @Resource
    private DelayMapper delayMapper;

    @Override
    public IBaseMapper<Delay> getBaseMapper() {
        return   this.delayMapper;
    }
}
