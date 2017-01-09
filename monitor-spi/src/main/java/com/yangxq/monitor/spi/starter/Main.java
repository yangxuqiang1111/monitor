package com.yangxq.monitor.spi.starter;

import com.yangxq.monitor.spi.service.HelloService;
import com.yangxq.monitor.spi.service.impl.ImageHelloServiceImpl;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.regex.Pattern;

/**
 * Created by Yangxq on 2016/12/28.
 */
public class Main {
    private static final Pattern NAME_SEPARATOR = Pattern.compile("\\s*[,]+\\s*");
    public static void main(String[] args) {
        ServiceLoader<HelloService> helloServices = ServiceLoader.load(HelloService.class);

        for (Iterator<HelloService> iterator = helloServices.iterator(); iterator.hasNext(); ) {
            HelloService helloService = iterator.next();
            helloService.sayHello();
        }
        boolean assignableFrom = HelloService.class.isAssignableFrom(ImageHelloServiceImpl.class);
        System.out.println(assignableFrom);

        String simpleName = HelloService.class.getSimpleName();
        System.out.println(simpleName);


        System.out.println("++++++++++++++++++++++++++");
        String[] strings = NAME_SEPARATOR.split(simpleName);

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
