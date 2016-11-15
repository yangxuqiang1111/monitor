package com.yangxq.monitor.test;

import java.util.*;

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
        String[] str = new String[enumMap.size()];
        String[] strings = enumMap.values().toArray(str);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
//        Iterator<Map.Entry<Week, String>> iterator = enumMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Week, String> next = iterator.next();
//            System.out.println("key: " + next.getKey() + ", value： " + next.getValue());
//        }

        EnumSet<Week> enumSet = EnumSet.allOf(Week.class);
        enumSet.add(Week.MONDAY);
        enumSet.add(Week.TUESDAY);
        Iterator<Week> enumSetIterator = enumSet.iterator();
        while (enumSetIterator.hasNext()) {
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
