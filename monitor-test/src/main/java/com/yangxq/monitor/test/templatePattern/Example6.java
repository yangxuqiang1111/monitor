package com.yangxq.monitor.test.templatePattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Yangxq on 2016/10/27.
 */
public class Example6 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
//        for (int i = 0, len = arrayList.size(); i < len; i++) {
//            arrayList.remove(i);
//        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
//
//        HashMap<Object, Object> hashMap = new HashMap();
//        hashMap.put("a", 1);
//        hashMap.put("b", 2);
//        Iterator<Map.Entry<Object, Object>> iterator = hashMap.entrySet().iterator();
//        while(iterator.hasNext()){
//            iterator.remove();
////            hashMap.remove(iterator.next().getKey());
//        }

//        Iterator<Map.Entry<Object, Object>> iterator = hashMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            iterator.next();
//            iterator.remove();
//        }
//        hashMap.forEach((key, value) -> {
//            System.out.println("key=" + key + ",value=" + value);
//        });

//        Iterator<Object> keyIterator = hashMap.keySet().iterator();
//        while (keyIterator.hasNext()) {
//            keyIterator.next();
//            keyIterator.remove();
//        }
//
//        hashMap.forEach((key, value) -> {
//            System.out.println("key=" + key + ",value=" + value);
//        });


    }
}
