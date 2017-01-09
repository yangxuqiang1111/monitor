package com.yangxq.monitor.spi.test;

import com.yangxq.monitor.spi.service.ByeService;
import com.yangxq.monitor.spi.service.HelloService;
import com.yangxq.monitor.spi.extender.ExtensionLoader;

/**
 * Created by Yangxq on 2016/12/28.
 */
public class Main1 {
    public static void main(String[] args) {
        ExtensionLoader<HelloService> extensionLoader = ExtensionLoader.getExtensionLoader(HelloService.class);
        HelloService imageHelloService = extensionLoader.getExtension("image");
        imageHelloService.sayHello();


        ExtensionLoader<ByeService> byeServiceExtensionLoader = ExtensionLoader.getExtensionLoader(ByeService.class);
        ByeService imageByeService = byeServiceExtensionLoader.getExtension("image");
        imageByeService.sayBye();
    }
}
