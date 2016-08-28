package com.yangxq.monitor.connector.msg.impl;

import com.yangxq.monitor.common.api.DelayProvider;
import com.yangxq.monitor.common.api.IBaseProvider;
import com.yangxq.monitor.common.po.Delay;
import com.yangxq.monitor.common.utils.Global;
import com.yangxq.monitor.connector.msg.IBaseMsgProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2016/8/26.
 * 耗时消息处理
 */
@Service("delayMsgProcessor")
public class DelayMsgProcessor implements IBaseMsgProcessor {

    @Resource
    private IBaseProvider<Delay> delayProvider;
    @Override
    public void handle(String msg) {
        String[] strings = msg.split(Global.SEPARATED);
        Delay delay=new Delay();
        delay.setBusinessId(Integer.parseInt(strings[2]));
        delay.setDelayTime(Integer.parseInt(strings[3]));
        delay.setTime(Integer.parseInt(strings[1]));
        delay.setType(Global);
        delayProvider.insert(delay);
    }
}
