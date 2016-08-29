package com.yangxq.monitor.common.api;

import com.yangxq.monitor.common.po.Transfer;

/**
 * Created by Yangxq on 2016/8/26.
 */
public interface TransferProvider{
    /**
     * 插入数据
     * @param transfer
     * @return
     */
    boolean insert(Transfer transfer);

}
