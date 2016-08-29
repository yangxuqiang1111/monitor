package com.yangxq.monitor.provider.service.impl;

import com.yangxq.monitor.common.po.Delay;
import com.yangxq.monitor.dao.mysql.mapper.DelayMapper;
import com.yangxq.monitor.dao.mysql.mapper.IBaseMapper;
import com.yangxq.monitor.provider.service.DelayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2016/8/29.
 */
@Service
public class DelayServiceImpl extends BaseServiceImpl<Delay> implements DelayService<Delay> {
    @Resource
    private DelayMapper delayMapper;
    @Override
    public IBaseMapper<Delay> getBaseMapper() {
        return this.delayMapper;
    }
}
