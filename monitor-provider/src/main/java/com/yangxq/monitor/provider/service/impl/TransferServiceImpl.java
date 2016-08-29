package com.yangxq.monitor.provider.service.impl;

import com.yangxq.monitor.common.po.Transfer;
import com.yangxq.monitor.dao.mysql.mapper.IBaseMapper;
import com.yangxq.monitor.dao.mysql.mapper.TransferMapper;
import com.yangxq.monitor.provider.service.TransferService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2016/8/29.
 */
@Service
public class TransferServiceImpl extends BaseServiceImpl<Transfer> implements TransferService<Transfer> {
    @Resource
    private TransferMapper transferMapper;
    @Override
    public IBaseMapper<Transfer> getBaseMapper() {
        return this.transferMapper;
    }
}
