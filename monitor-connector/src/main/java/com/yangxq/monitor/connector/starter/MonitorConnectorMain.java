package com.yangxq.monitor.connector.starter;

import com.yangxq.monitor.common.config.CommonConfig;
import com.yangxq.monitor.common.utils.SpringManager;
import com.yangxq.monitor.connector.netty.udp.UDPDelayServer;
import com.yangxq.monitor.connector.netty.udp.UDPTransferServer;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

/**
 * Created by Yangxq on 2016/8/26.
 * 启动类
 */
public class MonitorConnectorMain {
    private static ApplicationContext applicationContext;
    private static Logger log = Logger.getLogger(MonitorConnectorMain.class);

    public static void main(String[] args) {
        try {
            SpringManager.getInstance().init();
            applicationContext = SpringManager.getInstance().getContext();
            CommonConfig commonConfig = applicationContext.getBean(CommonConfig.class);
            // 启动调用udp服务
            UDPTransferServer udpTransferServer = applicationContext.getBean(UDPTransferServer.class);
            udpTransferServer.start(commonConfig.getUdpTransfer());

            // 启动耗时udp服务
            UDPDelayServer udpDelayServer = applicationContext.getBean(UDPDelayServer.class);
            udpDelayServer.start(commonConfig.getUdpDelay());

        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }
}
