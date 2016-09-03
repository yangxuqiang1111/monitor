package com.yangxq.monitor.connector.msg.impl;

import com.yangxq.monitor.common.utils.Global;
import com.yangxq.monitor.common.utils.StatisticMap;
import com.yangxq.monitor.connector.msg.IBaseMsgProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created by Yangxq on 2016/8/26.
 * 耗时消息处理
 */
@Service("delayMsgProcessor")
public class DelayMsgProcessor implements IBaseMsgProcessor {


    @Override
    public void handle(String msg) {
        String[] strings = msg.split(Global.SEPARATED);
//        Delay delay = new Delay();
//        delay.setBusinessId(Integer.parseInt(strings[2]));
//        delay.setDelayTime(Integer.parseInt(strings[3]));
////        delay.setTime(Integer.parseInt(strings[1]));
////        delay.setTime(LocalDateTime.parse(strings[1]).toInstant(ZoneOffset.UTC));
//        Long nano = LocalDateTime.parse(strings[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
//        delay.setTime(nano.intValue());
//        delay.setType(Global.BusinessType.DELAY.value);
//        delayProvider.insert(delay);
        int businessId = Integer.parseInt(strings[2]);
        int delayTime = Integer.parseInt(strings[3]);
        StatisticMap.getInstance().incrementDelayMap(businessId,delayTime);

    }

    public static void main(String[] args) {
        long nano = LocalDateTime.parse("2016-08-29 15:55:24", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
        System.out.println(nano);
    }
}
