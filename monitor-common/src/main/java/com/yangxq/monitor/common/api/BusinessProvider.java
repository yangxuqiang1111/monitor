package com.yangxq.monitor.common.api;

import com.yangxq.monitor.common.po.Business;

import java.util.List;

/**
 * Created by Yangxq on 2016/8/26.
 */
public interface BusinessProvider{
    /**
     * 插入数据
     * @param business
     * @return
     */
    boolean insert(Business business);

    /**
     * 获取
     * @param id
     * @return
     */
    Business get(int id);

    /**
     * 根据sysId 查询业务
     * @param sysId
     * @return
     */
    List<Business> listBySysId(int sysId);

}
