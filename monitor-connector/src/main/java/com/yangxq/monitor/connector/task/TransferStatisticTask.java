package com.yangxq.monitor.connector.task;

import com.yangxq.monitor.common.api.BusinessProvider;
import com.yangxq.monitor.common.api.EmailProvider;
import com.yangxq.monitor.common.api.StatisticProvider;
import com.yangxq.monitor.common.po.Business;
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

/**
 * Created by Yangxq on 2016/8/29.
 * 调用量（错误数）定时器
 */
@Component
public class TransferStatisticTask {
    private Logger log = Logger.getLogger(TransferStatisticTask.class);
    @Resource
    private StatisticProvider statisticProvider;

    @Resource
    private BusinessProvider businessProvider;

    @Resource
    private EmailProvider emailProvider;

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

        int nowMinute = DateUtil.getNowTimeStampRmS();
        log.info("定时统计耗时,加载时间是[" + nowMinute + "]");
        ConcurrentHashMap<Integer, AtomicInteger> transferMap = StatisticMap.getInstance().getTransferMap();
        for (Iterator<Map.Entry<Integer, AtomicInteger>> iterator = transferMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, AtomicInteger> next = iterator.next();
            Integer businessId = next.getKey();
            int transferNum = next.getValue().intValue();
            Business business = businessProvider.get(businessId);
            if (business.getType() == Global.BusinessType.ERROR.value) {
                if (transferNum >= business.getMax()) {
                    // 发送邮件
                    emailProvider.senderTextMail(getEmailSubject(business), business.getEmails().split(","), getEmailText(business));
                }

            }

            Statistics statistics = new Statistics();
            statistics.setType(business.getType());
            statistics.setNum(transferNum);
            statistics.setBusinessId(businessId);
            statistics.setTime(Long.valueOf(nowMinute));
            statisticProvider.insert(statistics);
        }

    }

    /**
     * 获取邮件内容
     * @param business
     * @return
     */
    private String getEmailText(Business business) {
        return business.getTitle()+"错误数超过最大值"+business.getMax();
    }

    /**
     * 获取邮件主题
     * @param business
     * @return
     */
    private String getEmailSubject(Business business) {
        return business.getTitle()+"错误数超过最大值"+business.getMax();
    }
}
