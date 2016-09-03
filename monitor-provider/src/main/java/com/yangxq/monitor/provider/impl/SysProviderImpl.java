package com.yangxq.monitor.provider.impl;

import com.yangxq.monitor.common.api.SysProvider;
import com.yangxq.monitor.common.po.Sys;

import java.util.List;

/**
 * Created by Yangxq on 2016/8/30.
 */
public class SysProviderImpl extends BaseProviderImpl implements SysProvider {
    @Override
    public List<Sys> list() {
        return sysService.list();
    }
}
