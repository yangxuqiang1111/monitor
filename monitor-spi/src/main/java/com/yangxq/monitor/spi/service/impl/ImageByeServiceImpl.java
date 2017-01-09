package com.yangxq.monitor.spi.service.impl;

import com.yangxq.monitor.spi.service.ByeService;

/**
 * Created by Yangxq on 2017/1/9.
 */
public class ImageByeServiceImpl implements ByeService {
    @Override
    public void sayBye() {
        System.out.println("image bye");
    }
}
