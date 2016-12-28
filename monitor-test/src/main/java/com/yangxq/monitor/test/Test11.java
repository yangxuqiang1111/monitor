package com.yangxq.monitor.test;

import java.lang.reflect.Method;

/**
 * Created by Yangxq on 2016/12/15.
 */
public class Test11 {
    public static void main(String[] args) {
        Integer a = new Integer(150);
        Integer b = new Integer(160);
        method1(a, b);

        System.out.println("a=" + a); // a为200
        System.out.println("b=" + b); // b为200
    }

    private static void method1(Integer a, Integer b) {
        a = new Integer(200);
    }
}
