package com.yangxq.monitor.common.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Yangxq on 2016/8/30.
 * 统计所需的map
 */
public class StatisticMap {
    private AtomicInteger transferNum;
    private StatisticMap() {
    }

    public AtomicInteger getTransferNum() {
        AtomicInteger atomicInteger = new AtomicInteger(Holder.statisticMap.transferNum.intValue());
        Holder.statisticMap.transferNum.set(0);
        return atomicInteger;

    }

    private static class Holder {
        private static StatisticMap statisticMap;

        static {
            statisticMap = new StatisticMap();
            statisticMap.delayMap = new ConcurrentHashMap<>();
            statisticMap.delayCallMap = new ConcurrentHashMap<>();
            statisticMap.transferMap = new ConcurrentHashMap<>();
            statisticMap.transferNum=new AtomicInteger(0);
        }
    }

    public static StatisticMap getInstance() {
        return Holder.statisticMap;
    }

    /**
     * 耗时统计map
     */
    private ConcurrentHashMap<Integer, AtomicLong> delayMap;

    /**
     * 耗时调用量
     */
    private ConcurrentHashMap<Integer, AtomicInteger> delayCallMap;

    /**
     * 调用量map
     */
    private ConcurrentHashMap<Integer, AtomicInteger> transferMap;


    /**
     * 增加耗时
     *
     * @param businessId
     * @param delayTime
     */
    public void incrementDelayMap(int businessId, int delayTime) {
        if (Holder.statisticMap.delayMap.containsKey(businessId)) {
            Holder.statisticMap.delayMap.get(businessId).addAndGet(delayTime);
        } else {
            Holder.statisticMap.delayMap.put(businessId, new AtomicLong(delayTime));
        }
        if (Holder.statisticMap.delayCallMap.containsKey(businessId)) {
            Holder.statisticMap.delayCallMap.get(businessId).incrementAndGet();
        } else {
            Holder.statisticMap.delayCallMap.put(businessId, new AtomicInteger(1));
        }
    }

    /**
     * 增加调用量
     *
     * @param businessId
     * @param num
     */
    public void incrementTransferMap(int businessId, int num) {
        if (Holder.statisticMap.transferMap.containsKey(businessId)) {
            Holder.statisticMap.transferMap.get(businessId).addAndGet(num);
        } else {
            Holder.statisticMap.transferMap.put(businessId, new AtomicInteger(num));
        }
    }

    /**
     * 获取耗时map
     *
     * @return
     */
    public ConcurrentHashMap<Integer, AtomicLong> getDelayMap() {
        ConcurrentHashMap<Integer, AtomicLong> map = new ConcurrentHashMap<>(Holder.statisticMap.delayMap);
        Holder.statisticMap.delayMap.clear();
        return map;
    }

    /**
     * 耗时调用量
     *
     * @return
     */
    public ConcurrentHashMap<Integer, AtomicInteger> getDelayCallMap() {
        ConcurrentHashMap<Integer, AtomicInteger> map = new ConcurrentHashMap<>(Holder.statisticMap.delayCallMap);
        Holder.statisticMap.delayCallMap.clear();
        return map;
    }

    /**
     * 获取调用量
     *
     * @return
     */
    public ConcurrentHashMap<Integer, AtomicInteger> getTransferMap() {
        ConcurrentHashMap<Integer, AtomicInteger> map = new ConcurrentHashMap<>(Holder.statisticMap.transferMap);
        Holder.statisticMap.transferMap.clear();
        return map;
    }

    public void incrementTransferNum(){
        Holder.statisticMap.transferNum.incrementAndGet();
    }

    public static void main(String[] args) {
        ConcurrentHashMap<Integer,AtomicLong>concurrentHashMap=new ConcurrentHashMap<>();
         concurrentHashMap.putIfAbsent(2, new AtomicLong(1)).incrementAndGet();
    }
}
