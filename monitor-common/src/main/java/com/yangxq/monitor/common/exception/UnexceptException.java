package com.yangxq.monitor.common.exception;

/**
 * Created by chjk on 16/4/6.
 */
public class UnexceptException extends RuntimeException {

    public UnexceptException(String msg) {
        super(msg);
    }

    public UnexceptException(String msg, Exception ex) {
        super(msg, ex);
    }

}