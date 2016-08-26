package com.yangxq.monitor.connector.msg.impl;

import com.yangxq.monitor.connector.msg.IBaseMsgProcessor;
import org.springframework.stereotype.Service;

/**
 * Created by Yangxq on 2016/8/26.
 * 耗时消息处理
 */
@Service("delayMsgProcessor")
public class DelayMsgProcessor implements IBaseMsgProcessor {
    @Override
    public void handle(String msg) {

    }
}
