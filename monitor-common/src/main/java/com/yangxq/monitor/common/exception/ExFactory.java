package com.yangxq.monitor.common.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常工厂
 */
public class ExFactory {

    protected static final Logger log = LoggerFactory.getLogger(ExFactory.class);

    public static void warnException(String msg) throws WarnException {
        throw new WarnException(msg);
    }

    /**
     * 用户验证异常
     *
     * @param msg 异常信息
     */
    public static void userAuthException(String msg) {
        throw new UserAuthException(msg);
    }

    /**
     * 参数异常
     *
     * @param msg 异常信息
     */
    public static void paramException(String msg) {
        throw new ParamException(msg);
    }

    /**
     * 异常信息
     *
     * @param msg
     * @param ex
     */
    public static void paramException(String msg, Exception ex) {
        throw new ParamException(msg, ex);
    }

    /**
     * Mysql异常
     *
     * @param msg 异常信息
     */
    public static void mysqlException(String msg) {
        throw new MysqlException(msg);
    }

    public static void mysqlException(String msg, Exception ex) {
        throw new MysqlException(msg, ex);
    }

    /**
     * 通用异常(其他未知异常)
     *
     * @param msg 异常信息
     * @param ex  异常栈信息
     */
    public static void exception(String msg, Exception ex) {
        throw new LiveException(msg, ex);
    }

    /**
     * 通用异常(其他未知异常)
     *
     * @param msg 异常信息
     */
    public static void exception(String msg) {
        throw new LiveException(msg);
    }

    public static void exception(RuntimeException ex) {
        throw ex;
    }


    /**
     * 不预期的\不希望发生的\系统必须支持的异常
     *
     * @param msg 异常信息
     * @param ex  异常栈信息
     */
    public static void unexceptException(String msg, Exception ex) {
        throw new UnexceptException(msg, ex);
    }

    public static void unexceptException(String msg) {
        throw new UnexceptException(msg);
    }
}
