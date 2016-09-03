package com.yangxq.monitor.worker.task;

import com.yangxq.monitor.dao.mysql.mapper.StatisticsMapper;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2016/8/29.
 */
//@Component
public class TransferStatisticTask {
    private Logger log=Logger.getLogger(TransferStatisticTask.class);
    @Resource
    private TransferMapper transferMapper;

    @Resource
    private StatisticsMapper statisticsMapper;

    /**
     *
     */
    @Scheduled(cron = "0 0/1 *  * * ? ")   //每1分钟执行一次
    public void publish() {
//        int nowMinute = DateUtil.getNowTimeStampRmS();
//        log.info("定时统计调用量,加载时间是["+nowMinute+"]");
//        List<Transfer> businessIds = transferMapper.listByTime(nowMinute - 60, nowMinute);
//        for (int i = 0; i < businessIds.size(); i++) {
//            Integer businessId = businessIds.get(i).getBusinessId();
//            List<Transfer> transfers = transferMapper.listByBusinessId(businessId, nowMinute - 60, nowMinute);
//            int transferNum = transfers.size();
//            Statistics statistics = new Statistics();
//            statistics.setNum(transferNum);
//            statistics.setBusinessId(businessId);
//            statistics.setType(Global.BusinessType.TRANSFER.value);
//            statistics.setTime(Long.valueOf(nowMinute));
//            statisticsMapper.insert(statistics);
//        }
//
//        int nowMinute = DateUtil.getNowTimeStampRmS();
//        log.info("定时统计耗时,加载时间是[" + nowMinute + "]");
//        ConcurrentHashMap<Integer, AtomicInteger> transferMap = StatisticMap.getInstance().getTransferMap();
//        for (Iterator<Map.Entry<Integer, AtomicInteger>> iterator = transferMap.entrySet().iterator(); iterator.hasNext(); ) {
//            Map.Entry<Integer, AtomicInteger> next = iterator.next();
//            Statistics statistics = new Statistics();
//            int transferNum =  next.getValue().intValue();
//            statistics.setNum(transferNum);
//            statistics.setBusinessId(next.getKey());
//            statistics.setType(Global.BusinessType.TRANSFER.value);
//            statistics.setTime(Long.valueOf(nowMinute));
//            statisticsMapper.insert(statistics);
//        }

    }
}
