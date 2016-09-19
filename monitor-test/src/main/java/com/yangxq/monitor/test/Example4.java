package com.yangxq.monitor.test;

/**
 * Created by Yangxq on 2016/9/19.
 * 一个8*8的方格子，A点在左下角，B点在右上角，求A点到B点的最短路径有多少条。
 */
public class Example4 {
    static int[][] f = new int[8][8];
    static int flag[][] = new int[9][9];
    static int sum = 0;

    public static void main(String[] args) {
        dfs(0, 0, 0);
        System.out.println(sum);
    }

    private static void dfs(int x, int y, int step) {
        if (x > 8 || y > 8 || x < 0 || y < 0 || flag[x][y] == 1 || step > 16) {
            return;
        }
        if (x == 8 && y == 8) {
            if (step == 16) {
                sum++;
            }
        } else {
            flag[x][y] = 1;
            step++;

            dfs(x + 1, y, step);
            dfs(x - 1, y, step);
            dfs(x, y + 1, step);
            dfs(x, y - 1, step);

            flag[x][y] = 0;
            step--;
        }

    }
}
