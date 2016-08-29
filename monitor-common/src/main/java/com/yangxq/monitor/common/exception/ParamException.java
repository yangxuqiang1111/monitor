package com.yangxq.monitor.common.exception;

/**
 * 参数异常
 */
public class ParamException extends RuntimeException {

    public ParamException(String msg) {
        super(msg);
    }

    public ParamException(String msg, Exception ex) {
        super(msg, ex);
    }

}

