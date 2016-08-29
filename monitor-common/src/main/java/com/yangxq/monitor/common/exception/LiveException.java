package com.yangxq.monitor.common.exception;

/**
 * 通用异常
 */
public class LiveException extends RuntimeException {

    public LiveException(String msg) {
        super(msg);
    }

    public LiveException(String msg, Exception ex) {
        super(msg, ex);
    }

}
