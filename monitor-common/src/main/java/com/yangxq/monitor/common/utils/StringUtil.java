package com.yangxq.monitor.common.utils;

import java.util.Random;
import java.util.regex.Pattern;

/**
 *字符串操作工具类
 */
public class StringUtil {
    /**
     * 获取随机字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        StringBuffer sb = new StringBuffer();
        int number = 0;
        for (int i = 0; i < length; i++) {
            number = MathUtil.randInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getHexString(byte[] b) {
        String info = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            info += hex.toUpperCase();
        }
        return info;
    }


    public static byte[] shortToByteArray(short s) {
        byte[] shortBuf = new byte[2];
        for (int i = 0; i < 2; i++) {
            int offset = (shortBuf.length - 1 - i) * 8;
            shortBuf[i] = (byte) ((s >>> offset) & 0xff);
        }
        return shortBuf;
    }

    // byte数组转换成short

    public static final int byteArrayToShort(byte[] b) {
        return (b[0] << 8) + (b[1] & 0xFF);
    }

    /**
     * 判断对象是否为空（转成字符串对象）
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        String s = obj2String(obj);
        if (s == null || s.trim().length() <= 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为空
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        if (s == null || s.trim().length() <= 0) {
            return true;
        }
        return false;
    }

    /**
     * 对象转换成字符串
     *
     * @param obj
     * @return
     */
    public static String obj2String(Object obj) {
        if (obj == null)
            return null;
        return String.valueOf(obj);
    }

    /**
     * 判断是否是手机号
     *
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        if (isEmpty(phone)) return false;
        return Pattern.matches("^[1][3,4,5,7,8][0-9]{9}$", phone);
    }

    /**
     * 随机生成6位短信验证码
     *
     * @return
     */
    public static String randMobileCode() {
        StringBuilder stb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stb.append(random.nextInt(10));
        }
        return stb.toString();
    }

    /**
     * 判断字符串是否为数值
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (isEmpty(str)) {
            return false;
        }
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断对象是否是整形（转成字符串对象）
     *
     * @param obj
     * @return
     */
    public static boolean isNumeric(Object obj) {
        String str = obj2String(obj);
        if (isEmpty(str)) {
            return false;
        }
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 对象转成整形
     *
     * @param obj
     * @return
     */
    public static Integer obj2Int(Object obj) {
        String str = obj2String(obj);
        if (str == null || !isNumeric(str))
            return null;
        return Integer.parseInt(str);
    }


    /**
     * 对象类型转成字节类型
     *
     * @param obj
     * @return
     */
    public static Byte obj2Byte(Object obj) {
        String str = obj2String(obj);
        if (str == null || !isNumeric(str))
            return null;
        return Byte.parseByte(str);
    }

    /**
     * 对象转成long
     *
     * @param obj
     * @return
     */
    public static Long obj2Long(Object obj) {
        String str = obj2String(obj);
        if (str == null || !isNumeric(str))
            return null;
        return Long.parseLong(str);
    }


}