package com.yangxq.monitor.connector.msg;

/**
 * Created by Yangxq on 2016/8/26.
 * 基本消息处理接口
 */
public interface IBaseMsgProcessor {
    /**
     *
     * @param msg
     */
    public void handle(String msg);
}
