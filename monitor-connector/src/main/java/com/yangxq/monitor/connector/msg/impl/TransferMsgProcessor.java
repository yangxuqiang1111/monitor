package com.yangxq.monitor.connector.msg.impl;

import com.yangxq.monitor.common.utils.Global;
import com.yangxq.monitor.common.utils.StatisticMap;
import com.yangxq.monitor.connector.msg.IBaseMsgProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2016/8/26.
 * 调用量消息处理
 */
@Service("transferMsgProcessor")
public class TransferMsgProcessor implements IBaseMsgProcessor {


    @Override
    public void handle(String msg) {
        String[] strings = msg.split(Global.SEPARATED);
//        Transfer transfer = new Transfer();
//        transfer.setBusinessId(Integer.parseInt(strings[2]));
//        transfer.setNum(Integer.parseInt(strings[3]));
////        transfer.setTime(Integer.parseInt(strings[1]));
//        Long nano = LocalDateTime.parse(strings[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
//        transfer.setTime(nano.intValue());
//        transfer.setType(Global.BusinessType.TRANSFER.value);
//        transferProvider.insert(transfer);

        int businessId = Integer.parseInt(strings[2]);
        int num = Integer.parseInt(strings[3]);
        StatisticMap.getInstance().incrementTransferMap(businessId,num);
    }
}
