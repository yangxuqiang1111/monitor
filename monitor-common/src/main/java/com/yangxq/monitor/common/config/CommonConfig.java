package com.yangxq.monitor.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Yangxq on 2016/8/26.
 */
@Component
public class CommonConfig {

    @Value("${udp_transfer}")
    private int udpTransfer;

    @Value("${udp_delay}")
    private int udpDelay;

    public int getUdpTransfer() {
        return udpTransfer;
    }

    public int getUdpDelay() {
        return udpDelay;
    }
}
