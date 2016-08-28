package com.yangxq.monitor.provider.impl;

import com.yangxq.monitor.common.api.TransferProvider;
import com.yangxq.monitor.common.po.Transfer;
import com.yangxq.monitor.dao.mysql.mapper.IBaseMapper;
import com.yangxq.monitor.dao.mysql.mapper.TransferMapper;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2016/8/26.
 * 调用监控服务
 */
public class TransferProviderImpl extends BaseProviderImpl<Transfer> implements TransferProvider<Transfer> {
    @Resource
    private TransferMapper transferMapper;
    @Override
    public IBaseMapper<Transfer> getBaseMapper() {
        return this.transferMapper;
    }
}
