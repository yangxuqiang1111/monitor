package com.yangxq.monitor.worker.starter;

import com.yangxq.monitor.common.utils.DaemonThread;
import com.yangxq.monitor.common.utils.SpringManager;
import org.apache.log4j.Logger;

/**
 * Created by Yangxq on 2016/8/29.
 */
public class MonitorWorkerStarter {
    private static Logger log = Logger.getLogger(MonitorWorkerStarter.class);

    public static void main(String[] args) {
        try {
            SpringManager.getInstance().init();
            new DaemonThread().start();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
