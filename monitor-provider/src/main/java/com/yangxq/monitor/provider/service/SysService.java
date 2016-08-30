package com.yangxq.monitor.provider.service;

import java.util.List;

/**
 * Created by Yangxq on 2016/8/30.
 */
public interface SysService<T> extends IBaseService<T> {
    /**
     *  列出系统
     * @return
     */
    List<T>list();
}
