package com.yangxq.monitor.common.exception;

/**
 * 用户验证失败异常
 */
public class UserAuthException extends RuntimeException {

    public UserAuthException(String msg) {
        super(msg);
    }

}
