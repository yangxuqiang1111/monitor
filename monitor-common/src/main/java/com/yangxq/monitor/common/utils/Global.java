package com.yangxq.monitor.common.utils;

/**
 * Created by Yangxq on 2016/8/26.
 */
public class Global {
    /**
     * 消息分隔符
     */
    public static final String  SEPARATED="-==-";


    public enum BusinessType{
        DELAY((byte) 1), // 耗时
        TRANSFER((byte) 2);//调用量
        public byte value;
        BusinessType(byte value){
            this.value=value;
        }
    }
}
