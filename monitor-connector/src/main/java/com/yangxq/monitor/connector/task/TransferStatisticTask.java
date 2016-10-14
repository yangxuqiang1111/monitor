package com.yangxq.monitor.connector.task;

import com.yangxq.monitor.common.api.BusinessProvider;
import com.yangxq.monitor.common.api.EmailProvider;
import com.yangxq.monitor.common.api.StatisticProvider;
import com.yangxq.monitor.common.po.Business;
import com.yangxq.monitor.common.po.Statistics;
import com.yangxq.monitor.common.utils.DateUtil;
import com.yangxq.monitor.common.utils.Global;
import com.yangxq.monitor.common.utils.StatisticMap;
import com.yangxq.monitor.common.utils.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

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
        log.info("transferNum:" + StatisticMap.getInstance().getTransferNum());

        int nowMinute = DateUtil.getNowTimeStampRmS();
        log.info("定时统计耗时,加载时间是[" + nowMinute + "]");
        ConcurrentHashMap<Integer, LongAdder> transferMap = StatisticMap.getInstance().getTransferMap();
        for (Iterator<Map.Entry<Integer, LongAdder>> iterator = transferMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, LongAdder> next = iterator.next();
            Integer businessId = next.getKey();
            int transferNum = next.getValue().intValue();
            log.info("transferMap key[" + next.getKey() + "],调用次数是[" + next.getValue() + "]");
            Business business = businessProvider.get(businessId);
            if (business.getType() == Global.BusinessType.ERROR.value) {
                if (transferNum >= business.getMax()) {
                    // 发送邮件
                    sendEmail(business, Global.AlarmBusinessType.ERROR_MAX.value);
                    /**
                     * TODO  发送短信
                     */
                }

            } else if (business.getType() == Global.BusinessType.TRANSFER.value) {
                if (transferNum > business.getMax()) {
                    sendEmail(business, Global.AlarmBusinessType.TRANSFER_MAX.value);
                    /**
                     * TODO 发送短信
                     */
                }
                if (transferNum < business.getMin()) {
                    sendEmail(business, Global.AlarmBusinessType.TRANSFER_MIN.value);
                    /**
                     * TODO 发送短信
                     */
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
     * 发送邮件
     *
     * @param business
     * @param value
     */
    private void sendEmail(Business business, int value) {
        if (!StringUtil.isEmpty(business.getEmails())) {
            emailProvider.senderTextMail(getEmailSubject(business, value), business.getEmails().split(","), getEmailText(business, value));
        }
    }

    /**
     * 获取邮件内容
     *
     * @param business
     * @param value
     * @return
     */
    private String getEmailText(Business business, int value) {
        if (value == Global.AlarmBusinessType.ERROR_MAX.value) {
            return business.getTitle() + "错误数超过最大值" + business.getMax();
        } else if (value == Global.AlarmBusinessType.TRANSFER_MAX.value) {
            return business.getTitle() + "调用量超过最大值" + business.getMax();
        } else if (value == Global.AlarmBusinessType.TRANSFER_MIN.value) {
            return business.getTitle() + "调用量超过最大值" + business.getMax();
        } else {
            log.error("不支持的类型[" + value + "]");
            return null;
        }
    }

    /**
     * 获取邮件主题
     *
     * @param business
     * @param value
     * @return
     */
    private String getEmailSubject(Business business, int value) {
        if (value == Global.AlarmBusinessType.ERROR_MAX.value) {
            return business.getTitle() + "错误数超过最大值" + business.getMax();
        } else if (value == Global.AlarmBusinessType.TRANSFER_MAX.value) {
            return business.getTitle() + "调用量超过最大值" + business.getMax();
        } else if (value == Global.AlarmBusinessType.TRANSFER_MIN.value) {
            return business.getTitle() + "调用量超过最大值" + business.getMax();
        } else {
            log.error("不支持的类型[" + value + "]");
            return null;
        }
    }
}
