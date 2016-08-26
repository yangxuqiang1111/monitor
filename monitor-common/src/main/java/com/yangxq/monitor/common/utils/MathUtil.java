package com.yangxq.monitor.common.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机工具类
 */
public class MathUtil {

    /**
     * 获取自定义随机数
     *
     * @param num
     * @return
     */
    public static int randInt(int num) {
        return ThreadLocalRandom.current().nextInt(num);
    }

}
