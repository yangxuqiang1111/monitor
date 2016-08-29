package com.yangxq.monitor.common.exception;

/**
 * 数据库异常
 */
public class MysqlException extends RuntimeException {

    public MysqlException(String msg) {
        super(msg);
    }

    public MysqlException(String msg, Exception ex) {
        super(msg, ex);
    }
}
