package com.yangxq.monitor.test;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Yangxq on 2016/11/3.
 */
public class Example8 {
    public static void main(String[] args) {
        EnumMap<Week, String> enumMap = new EnumMap(Week.class);
        enumMap.put(Week.MONDAY, "星期一");
        enumMap.put(Week.TUESDAY, "星期二");
        enumMap.put(Week.WEDNESDAY, "星期三");
        enumMap.put(Week.WEDNESDAY, "星期四");

        Iterator<Map.Entry<Week, String>> iterator = enumMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Week, String> next = iterator.next();
            System.out.println("key: " + next.getKey() + ", value： " + next.getValue());
        }

        EnumSet<Week> enumSet = EnumSet.allOf(Week.class);
        enumSet.add(Week.MONDAY);
        enumSet.add(Week.TUESDAY);
        Iterator<Week> enumSetIterator = enumSet.iterator();
        while (enumSetIterator.hasNext()){
            Week next = enumSetIterator.next();
            System.out.println(next.name());

        }
    }

    enum Week {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

}
