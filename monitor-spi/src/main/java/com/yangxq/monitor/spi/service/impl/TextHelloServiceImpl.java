package com.yangxq.monitor.spi.service.impl;

import com.yangxq.monitor.spi.service.HelloService;

/**
 * Created by Yangxq on 2016/12/28.
 */
public class TextHelloServiceImpl implements HelloService {
    public void sayHello() {
        System.out.println("text hello");
    }
}
