package com.yangxq.monitor.test.templatePattern;

/**
 * Created by Yangxq on 2016/9/12.
 */
public class Tea extends AbstractBerverage {
    @Override
    public void boilWater(String str) {
        System.out.println("烧煮茶的水"+str);
    }

    @Override
    public void pourInCup() {
        System.out.println("把茶叶到水杯");
    }

    @Override
    public void brew() {
        System.out.println("用水冲茶叶");
    }

    @Override
    public void addCoundiments() {
        System.out.println("添加蜂蜜");
    }
}
