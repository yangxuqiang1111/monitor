package com.yangxq.monitor.dao.mysql.mapper;

import com.yangxq.monitor.common.po.Delay;

import java.util.List;

public interface DelayMapper extends IBaseMapper<Delay> {
    /**
     * 列出当前分钟的耗时的BusinessId
     *
     * @param bef
     * @param aft
     * @return
     */
    List<Delay> listByTime(int bef, int aft);

    /**
     * 根据Businessid和时间列出当前的请求数量
     * @param businessId
     * @param bef
     * @param aft
     * @return
     */
    List<Delay> listByBusinessId(Integer businessId, int bef, int aft);
}