package com.yangxq.monitor.provider.starter;

import com.yangxq.monitor.common.utils.DaemonThread;
import com.yangxq.monitor.common.utils.SpringManager;
import org.apache.log4j.Logger;

/**
 * Created by Yangxq on 2016/8/26.
 */
public class MonitorProviderMain {
    private static Logger log = Logger.getLogger(MonitorProviderMain.class);

    public static void main(String[] args) {
        try {
            SpringManager.getInstance().init();

            new DaemonThread().start();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }
}
