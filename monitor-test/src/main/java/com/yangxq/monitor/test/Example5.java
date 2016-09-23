package com.yangxq.monitor.test;

/**
 * Created by Yangxq on 2016/9/23.
 */
public class Example5 {
    public static void main(String[] args) {

        System.setSecurityManager(new SecurityManager(){
            @Override
            public void checkExit(int status) {
                throw new ThreadDeath();
            }
        });
        try {
            System.exit(0);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(123);
        }
    }
}
