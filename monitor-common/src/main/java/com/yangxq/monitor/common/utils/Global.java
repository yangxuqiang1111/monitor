package com.yangxq.monitor.common.utils;

import java.util.HashMap;
import java.util.Map;

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
    private static Map<Byte,String> subTitleMap;
    static {
        subTitleMap=new HashMap<>();
        subTitleMap.put(BusinessType.DELAY.value,"单位:毫秒");
        subTitleMap.put(BusinessType.TRANSFER.value,"Total:");
    }
    public static String getSubTitle(byte key){
        return subTitleMap.get(key);
    }

    private static Map<Byte,String>yTitleMap;
    static {
        yTitleMap=new HashMap<>();
        yTitleMap.put(BusinessType.DELAY.value,"接口耗时");
        yTitleMap.put(BusinessType.TRANSFER.value,"调用量");
    }
    public static String getYtitle(Byte type) {
        return yTitleMap.get(type);
    }

    private static Map<Byte,String>nameTitleMap;
    static {
        nameTitleMap=new HashMap<>();
        nameTitleMap.put(BusinessType.DELAY.value,"当前分钟接口延迟");
        nameTitleMap.put(BusinessType.TRANSFER.value,"当前分钟调用量");
    }
    public static String getName(Byte type) {
        return nameTitleMap.get(type);
    }
}
