package com.yangxq.monitor.test;

import com.yangxq.monitor.common.utils.MathUtil;

import java.util.Arrays;

/**
 * Created by Yangxq on 2016/9/7.
 */
public class Example2 {
    public static void main(String[] args) {
        int len = 100000000;
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = MathUtil.randInt(len);
        }
        long beg = System.currentTimeMillis();
        Arrays.parallelSort(a);
        long end = System.currentTimeMillis();
        System.out.println("parallel间隔" + (end - beg) + "ms");

        beg = System.currentTimeMillis();
        Arrays.sort(a);
        end = System.currentTimeMillis();
        System.out.println("间隔" + (end - beg) + "ms");

    }
}
