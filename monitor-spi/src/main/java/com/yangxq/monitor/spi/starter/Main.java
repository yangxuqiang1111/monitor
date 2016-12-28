package com.yangxq.monitor.spi.starter;

import com.yangxq.monitor.spi.HelloService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by Yangxq on 2016/12/28.
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<HelloService> helloServices = ServiceLoader.load(HelloService.class);

        for (Iterator<HelloService> iterator = helloServices.iterator(); iterator.hasNext(); ) {
            HelloService helloService = iterator.next();
            helloService.sayHello();
        }
    }
}
