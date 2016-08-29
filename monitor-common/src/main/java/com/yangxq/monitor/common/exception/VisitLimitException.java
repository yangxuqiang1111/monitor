package com.yangxq.monitor.common.exception;

/**
 * 访问限流异常
 */
public class VisitLimitException extends RuntimeException {

    public VisitLimitException(String msg) {
        super(msg);
    }
}
