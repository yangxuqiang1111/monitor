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

public class DelayProviderImpl extends BaseProviderImpl implements DelayProvider{

    @Override
    public boolean insert(Delay delay) {
        return delayService.insert(delay);
    }
}
