package com.yangxq.monitor.worker.task;

import com.yangxq.monitor.common.po.Statistics;
import com.yangxq.monitor.common.utils.DateUtil;
import com.yangxq.monitor.common.utils.Global;
import com.yangxq.monitor.common.utils.StatisticMap;
import com.yangxq.monitor.dao.mysql.mapper.DelayMapper;
import com.yangxq.monitor.dao.mysql.mapper.StatisticsMapper;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Yangxq on 2016/8/29.
 */
//@Component
public class DelayStatisticTask {
    private Logger log = Logger.getLogger(DelayStatisticTask.class);
    @Resource
    private DelayMapper delayMapper;

    @Resource
    private StatisticsMapper statisticsMapper;

    /**
     *
     */
    @Scheduled(cron = "0 0/1 *  * * ? ")   //每1分钟执行一次
    public void publish() {
//        int nowMinute = DateUtil.getNowTimeStampRmS();
//        log.info("定时统计耗时,加载时间是["+nowMinute+"]");
//        List<Delay> businessIds = delayMapper.listByTime(nowMinute - 60, nowMinute);
//       for (int i=0;i<businessIds.size();i++){
//           Integer businessId = businessIds.get(i).getBusinessId();
//           List<Delay> delays = delayMapper.listByBusinessId(businessId, nowMinute - 60, nowMinute);
//           int delayTime = 0, sum = delays.size();
//           for (int j = 0; j < sum; j++) {
//               Delay delay = delays.get(j);
//               delayTime += delay.getDelayTime();
//           }
//           delayTime= (int) Math.ceil(delayTime/sum);
//
//           Statistics statistics = new Statistics();
//           statistics.setNum(delayTime);
//           statistics.setBusinessId(businessId);
//           statistics.setType(Global.BusinessType.DELAY.value);
//           statistics.setTime(Long.valueOf(nowMinute));
//           statisticsMapper.insert(statistics);
//       }
//        int nowMinute = DateUtil.getNowTimeStampRmS();
//        log.info("定时统计耗时,加载时间是[" + nowMinute + "]");
//        ConcurrentHashMap<Integer, AtomicInteger> delayMap = StatisticMap.getInstance().getDelayMap();
//        ConcurrentHashMap<Integer, AtomicInteger> delayTimeMap = StatisticMap.getInstance().getDelayTimeMap();
//        for (Iterator<Map.Entry<Integer, AtomicInteger>> iterator = delayMap.entrySet().iterator(); iterator.hasNext(); ) {
//            Map.Entry<Integer, AtomicInteger> next = iterator.next();
//            Statistics statistics = new Statistics();
//            int delayTime = (int) Math.ceil(next.getValue().intValue() / delayTimeMap.get(next.getKey()).intValue());
//            statistics.setNum(delayTime);
//            statistics.setBusinessId(next.getKey());
//            statistics.setType(Global.BusinessType.DELAY.value);
//            statistics.setTime(Long.valueOf(nowMinute));
//            statisticsMapper.insert(statistics);
//        }
    }
}
