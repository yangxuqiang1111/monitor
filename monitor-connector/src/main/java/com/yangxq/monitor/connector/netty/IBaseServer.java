package com.yangxq.monitor.connector.netty;

/**
 * Created by Yangxq on 2016/8/22.
 */
public interface IBaseServer {
    /**
     * 开始
     *
     * @param port
     */
    void start(int port);

    /**
     * 关闭
     */
    void stop();
}
