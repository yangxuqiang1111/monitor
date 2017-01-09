package com.yangxq.monitor.test;

/**
 * Created by Yangxq on 2016/12/30.
 */
public class ShiftTest {
    public static void main(String[] args) {
        long a = doShiftL(291);
        System.out.println(a);
    }

    private static long doShiftL(int num) {
        return 4L << num;
    }
}
