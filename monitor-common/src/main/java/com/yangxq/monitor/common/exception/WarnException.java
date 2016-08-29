package com.yangxq.monitor.common.exception;

/**
 * 警告异常
 */
public class WarnException extends Exception {

    public WarnException(String msg) {
        super(msg);
    }

    public WarnException(String msg, Exception ex) {
        super(msg, ex);
    }

}
