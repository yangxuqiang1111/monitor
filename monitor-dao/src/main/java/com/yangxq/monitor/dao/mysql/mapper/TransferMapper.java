package com.yangxq.monitor.dao.mysql.mapper;

import com.yangxq.monitor.common.po.Transfer;

import java.util.List;

public interface TransferMapper extends IBaseMapper<Transfer> {

List<Transfer> listByTime(int bef, int aft);

    List<Transfer> listByBusinessId(Integer businessId, int bef, int aft);
}