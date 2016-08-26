package com.yangxq.monitor.common.utils;

import org.apache.log4j.Logger;

/**
 * 守护线程
 */
public class DaemonThread extends Thread {

    private static Logger log = Logger.getLogger(DaemonThread.class);

    private final long SLEEP_TIME = 500L;

    @Override
    public void run() {
        while (true) {
            try {
                sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

}
