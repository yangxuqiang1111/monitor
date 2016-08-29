package com.yangxq.monitor.common.api;

import com.yangxq.monitor.common.po.Business;
import com.yangxq.monitor.common.po.Statistics;

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

}
