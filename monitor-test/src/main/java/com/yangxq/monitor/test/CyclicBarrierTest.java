package com.yangxq.monitor.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Yangxq on 2016/12/15.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclic = new CyclicBarrier(3);
        Executor pool = Executors.newFixedThreadPool(3);
        pool.execute(new Runner("1号选手", cyclic));
        pool.execute(new Runner("2号选手", cyclic));
        pool.execute(new Runner("3号选手", cyclic));
    }
}

class Runner implements Runnable {
    private String name;
    private CyclicBarrier cyclicBarrier;

    public Runner(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(name + "  准备好了");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + " 起跑！");
    }
}
