package com.yangxq.monitor.connector.task;

import com.yangxq.monitor.common.api.StatisticProvider;
import com.yangxq.monitor.common.po.Statistics;
import com.yangxq.monitor.common.utils.DateUtil;
import com.yangxq.monitor.common.utils.Global;
import com.yangxq.monitor.common.utils.StatisticMap;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Yangxq on 2016/8/29.
 * 耗时 统计定时器
 */
@Component
public class DelayStatisticTask {
    private Logger log = Logger.getLogger(DelayStatisticTask.class);
    //    @Resource
//    private DelayMapper delayMapper;
//
//    @Resource
//    private StatisticsMapper statisticsMapper;
    @Resource
    private StatisticProvider statisticProvider;

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
        int nowMinute = DateUtil.getNowTimeStampRmS();
        log.info("定时统计耗时,加载时间是[" + nowMinute + "]");
        ConcurrentHashMap<Integer, LongAdder> delayMap = StatisticMap.getInstance().getDelayMap();
        ConcurrentHashMap<Integer, LongAdder> delayCallMap = StatisticMap.getInstance().getDelayCallMap();
        for (Iterator<Map.Entry<Integer, LongAdder>> iterator = delayMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, LongAdder> next = iterator.next();

            Statistics statistics = new Statistics();
            long delayTime = next.getValue().longValue();
            int delayCall = 0;
            if (delayCallMap.containsKey(next.getKey())) {
                delayCall = delayCallMap.get(next.getKey()).intValue();
                delayTime = (int) Math.ceil(next.getValue().intValue() / delayCall);
            }
            log.info("delayMap key[" + next.getKey() + "],value[" + next.getValue() + "],调用次数是[" + delayCall + "]");
            statistics.setNum((int) delayTime);
            statistics.setBusinessId(next.getKey());
            statistics.setType(Global.BusinessType.DELAY.value);
            statistics.setTime(Long.valueOf(nowMinute));
            statisticProvider.insert(statistics);
        }
    }
}
