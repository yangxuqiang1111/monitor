package com.yangxq.monitor.common.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Yangxq on 2016/8/30.
 */
public class StatisticMap {
    private StatisticMap(){}
    private static class Holder{
        private static StatisticMap statisticMap;
        static{
            statisticMap=new StatisticMap();
            statisticMap.delayMap=new ConcurrentHashMap<>();
            statisticMap.delayTimeMap=new ConcurrentHashMap<>();
            statisticMap.transferMap=new ConcurrentHashMap<>();
        }
    }
   public static StatisticMap getInstance(){
      return Holder.statisticMap;
   }
    /**
     * 耗时统计map
     */
    private  ConcurrentHashMap<Integer,AtomicInteger> delayMap;

    /**
     * 耗时的调用量
     */
    private  ConcurrentHashMap<Integer,AtomicInteger>delayTimeMap;

    /**
     * 调用量map
     */
    private   ConcurrentHashMap<Integer,AtomicInteger>transferMap;



    /**
     * 增加耗时
     * @param businessId
     * @param delayTime
     */
    public  void incrementDelayMap(int businessId, int delayTime) {
        if (Holder.statisticMap.delayMap.containsKey(businessId)){
            Holder.statisticMap.delayMap.get(businessId).addAndGet(delayTime);
        }else {
            Holder.statisticMap.delayMap.put(businessId,new AtomicInteger(delayTime));
        }
        if (Holder.statisticMap.delayTimeMap.containsKey(businessId)){
            Holder.statisticMap.delayTimeMap.get(businessId).incrementAndGet();
        }else {
            Holder.statisticMap.delayTimeMap.put(businessId,new AtomicInteger(1));
        }
    }
    /**
     * 增加调用量
     * @param businessId
     * @param num
     */
    public  void incrementTransferMap(int businessId, int num) {
        if (Holder.statisticMap.transferMap.containsKey(businessId)){
            Holder.statisticMap.transferMap.get(businessId).addAndGet(num);
        }else {
            Holder.statisticMap.transferMap.put(businessId,new AtomicInteger(num));
        }
    }

    /**
     * 获取耗时map
     * @return
     */
    public  ConcurrentHashMap<Integer,AtomicInteger>getDelayMap(){
        ConcurrentHashMap<Integer,AtomicInteger> map=new ConcurrentHashMap<>(Holder.statisticMap.delayMap);
        Holder.statisticMap.delayMap.clear();
        return map;
    }

    /**
     * 耗时调用量
     * @return
     */
    public  ConcurrentHashMap<Integer,AtomicInteger>getDelayTimeMap(){
        ConcurrentHashMap<Integer,AtomicInteger> map=new ConcurrentHashMap<>(Holder.statisticMap.delayTimeMap);
        Holder.statisticMap.delayTimeMap.clear();
        return map;
    }

    /**
     * 获取调用量
     * @return
     */
    public  ConcurrentHashMap<Integer, AtomicInteger> getTransferMap() {
        ConcurrentHashMap<Integer,AtomicInteger> map=new ConcurrentHashMap<>(Holder.statisticMap.transferMap);
        Holder.statisticMap.transferMap.clear();
        return map;
    }
}
