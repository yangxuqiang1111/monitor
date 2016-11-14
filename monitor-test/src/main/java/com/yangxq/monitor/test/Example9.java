package com.yangxq.monitor.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by yangxuqiang on 2016/11/13.
 */
public class Example9 {
    private String str;


    public Example9() {
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Integer.parseInt("1"));
        System.out.println();
        new FileInputStream(String.valueOf(Files.createFile(Paths.get(""))));
        String s = new String();
        System.out.println(s.length());
        System.out.println(s.length());
    }
}
