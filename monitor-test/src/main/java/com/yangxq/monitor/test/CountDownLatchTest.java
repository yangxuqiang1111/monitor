package com.yangxq.monitor.test;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Yangxq on 2016/12/15.
 * test countDownLatch
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        client.start();
        final InterProcessMutex lock = new InterProcessMutex(client, lockPath);
        final CountDownLatch down = new CountDownLatch(1);
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        down.await();
                        lock.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    SimpleDateFormat sld = new SimpleDateFormat("HH:mm:ss|SSS");
                    String orderNo = sld.format(new Date());
                    System.out.println("生成的订单号是：" + orderNo);
                    try {
                        lock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        down.countDown();
    }

    static String lockPath = "/lock_path";
    static String zookeeper = "127.0.0.1:2181";
    static CuratorFramework client = CuratorFrameworkFactory.builder().connectString(zookeeper)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

    public void test1() {
        final CountDownLatch down = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("aaa");
                    try {
                        down.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SimpleDateFormat sld = new SimpleDateFormat("HH:mm:ss|SSS");
                    String orderNo = sld.format(new Date());
                    System.out.println("生成的订单号是：" + orderNo);
                }
            }).start();
        }
        down.countDown();
    }
}
