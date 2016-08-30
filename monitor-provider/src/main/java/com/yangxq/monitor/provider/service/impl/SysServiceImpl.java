package com.yangxq.monitor.provider.service.impl;

import com.yangxq.monitor.common.po.Sys;
import com.yangxq.monitor.dao.mysql.mapper.IBaseMapper;
import com.yangxq.monitor.dao.mysql.mapper.SysMapper;
import com.yangxq.monitor.provider.service.SysService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yangxq on 2016/8/30.
 */
public class SysServiceImpl extends  BaseServiceImpl<Sys> implements SysService<Sys> {
    @Resource
    private SysMapper sysMapper;
    @Override
    public IBaseMapper<Sys> getBaseMapper() {
        return this.sysMapper;
    }

    @Override
    public List<Sys> list() {
        return this.sysMapper.list();
    }
}
