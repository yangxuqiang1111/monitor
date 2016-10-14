package com.yangxq.monitor.common.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Yangxq on 2016/8/30.
 * 统计所需的map
 */
public class StatisticMap {
    private LongAdder transferNum;

    private StatisticMap() {
    }

    public long getTransferNum() {
        return Holder.statisticMap.transferNum.sumThenReset();

    }

    private static class Holder {
        private static StatisticMap statisticMap;

        static {
            statisticMap = new StatisticMap();
            statisticMap.delayMap = new ConcurrentHashMap<>();
            statisticMap.delayCallMap = new ConcurrentHashMap<>();
            statisticMap.transferMap = new ConcurrentHashMap<>();
            statisticMap.transferNum = new LongAdder();
        }
    }

    public static StatisticMap getInstance() {
        return Holder.statisticMap;
    }

    /**
     * 耗时统计map
     */
    private ConcurrentHashMap<Integer, LongAdder> delayMap;

    /**
     * 耗时调用量
     */
    private ConcurrentHashMap<Integer, LongAdder> delayCallMap;

    /**
     * 调用量map
     */
    private ConcurrentHashMap<Integer, LongAdder> transferMap;


    /**
     * 增加耗时
     *
     * @param businessId
     * @param delayTime
     */
    public void incrementDelayMap(int businessId, int delayTime) {
        if (Holder.statisticMap.delayMap.containsKey(businessId)) {
            Holder.statisticMap.delayMap.get(businessId).add(delayTime);
        } else {
            Holder.statisticMap.delayMap.computeIfAbsent(businessId, integer -> new LongAdder()).add(delayTime);
        }
        if (Holder.statisticMap.delayCallMap.containsKey(businessId)) {
            Holder.statisticMap.delayCallMap.get(businessId).increment();
        } else {
            Holder.statisticMap.delayCallMap.computeIfAbsent(businessId, integer -> new LongAdder()).increment();
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
            Holder.statisticMap.transferMap.get(businessId).add(num);
        } else {
            Holder.statisticMap.transferMap.computeIfAbsent(businessId, integer -> new LongAdder()).increment();
        }
    }

    /**
     * 获取耗时map
     *
     * @return
     */
    public ConcurrentHashMap<Integer, LongAdder> getDelayMap() {
        ConcurrentHashMap<Integer, LongAdder> map = new ConcurrentHashMap<>(Holder.statisticMap.delayMap);
        Holder.statisticMap.delayMap.clear();
        return map;
    }

    /**
     * 耗时调用量
     *
     * @return
     */
    public ConcurrentHashMap<Integer, LongAdder> getDelayCallMap() {
        ConcurrentHashMap<Integer, LongAdder> map = new ConcurrentHashMap<>(Holder.statisticMap.delayCallMap);
        Holder.statisticMap.delayCallMap.clear();
        return map;
    }

    /**
     * 获取调用量
     *
     * @return
     */
    public ConcurrentHashMap<Integer, LongAdder> getTransferMap() {
        ConcurrentHashMap<Integer, LongAdder> map = new ConcurrentHashMap<>(Holder.statisticMap.transferMap);
        Holder.statisticMap.transferMap.clear();
        return map;
    }

    public void incrementTransferNum() {
        Holder.statisticMap.transferNum.increment();
    }

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, LongAdder> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.computeIfAbsent(2, integer -> new LongAdder()).increment();
        System.out.println(concurrentHashMap.get(2));
        concurrentHashMap.computeIfPresent(2, (integer, longAdder) -> new LongAdder());
        System.out.println(concurrentHashMap.get(2));

    }
}
