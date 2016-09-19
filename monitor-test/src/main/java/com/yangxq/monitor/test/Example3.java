package com.yangxq.monitor.test;

import java.util.Scanner;

/**
 * Created by Yangxq on 2016/9/19.
 * 将一个数组右移几位，比如数组为1 2 3 4，右移一位即为4 1 2 3。
 */
public class Example3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int len = cin.nextInt();

            System.out.println(len<<1);
            int m = cin.nextInt();
            int[] f = new int[len];
            for (int i = 0; i < len; i++) {
                f[i] = cin.nextInt();
            }

            int i = 0,  index = 0, temp = f[0],a;
            while (i < len) {
                i++;
                a=temp;
                index = (index + m) % len;
                temp = f[index];
                f[index] = a;
            }
            for (i = 0; i < len; i++) {
                System.out.print(f[i]+"  ");
            }
            System.out.println();
        }
    }
}
