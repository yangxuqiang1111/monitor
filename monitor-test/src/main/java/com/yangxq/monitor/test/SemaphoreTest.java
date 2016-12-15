package com.yangxq.monitor.test;

import java.util.concurrent.Semaphore;

/**
 * Created by Yangxq on 2016/12/15.
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 8; i++) {
            new Thread(new Waiter(semaphore, "工人" + i)).start();
        }
    }
}

class Waiter implements Runnable {
    private Semaphore semaphore;
    private String name;

    public Waiter(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(name + " 占用了一台机器在生产");
            Thread.sleep(2000);
            System.out.println(name + " 释放机器");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
