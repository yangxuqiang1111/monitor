package com.yangxq.monitor.spi.extender;

/**
 * Created by Yangxq on 2017/1/9.
 */
public class Holder<T> {
    private volatile T value;

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}
