package com.yangxq.monitor.connector.msg;

import com.yangxq.monitor.common.utils.Global;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2016/8/26.
 */
@Component
public class MsgDistributor {
    private Logger log = Logger.getLogger(MsgDistributor.class);

    @Resource(name = "delayMsgProcessor")
    private IBaseMsgProcessor delayMsgProcessor;

    @Resource(name = "transferMsgProcessor")
    private IBaseMsgProcessor transferMsgProcessor;

    public void handle(String msg, byte type) {
        if (type == Global.BusinessType.DELAY.value) {
            delayMsgProcessor.handle(msg);
        } else if (type == Global.BusinessType.TRANSFER.value) {
            transferMsgProcessor.handle(msg);
        }else {
            log.error("消息["+msg+"] 类型["+type+"]不正确");
        }

    }
}
