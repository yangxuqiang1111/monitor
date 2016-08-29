package com.yangxq.monitor.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * MD5
 */
public class MD5Util {

    private final static Logger log = LoggerFactory.getLogger(MD5Util.class);

    public final static String getMD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput;
        MessageDigest mdInst;
        try {
            btInput = s.getBytes("utf-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            mdInst = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }

        // 使用指定的字节更新摘要
        mdInst.update(btInput);
        // 获得密文
        byte[] md = mdInst.digest();
        // 把密文转换成十六进制的字符串形式
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

    /**
     * 获取文件名称
     *
     * @param userId
     * @return
     */
    public static String getFileName(String userId) {
        long random = (long) (Math.random() * (9999 - 1000 + 1)) + 1000;  //四位随机数
        long currentTime = System.currentTimeMillis();  //时间戳
        return getMD5("" + currentTime + userId + random);  //MD5转码 时间戳+用户ID+四位随机数
    }

    public static void main(String[] args) {
        System.out.println(MD5Util.getMD5("20121221"));
    }
}