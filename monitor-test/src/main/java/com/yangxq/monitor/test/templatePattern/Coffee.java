package com.yangxq.monitor.test.templatePattern;

/**
 * Created by Yangxq on 2016/9/12.
 */
public class Coffee extends AbstractBerverage {
    @Override
    public void boilWater(String str) {
        System.out.println("烧咖啡水"+str);

    }

    @Override
    public void pourInCup() {
        System.out.println("把咖啡到杯子里");
    }

    @Override
    public void brew() {
        System.out.println("用水冲咖啡");
    }

    @Override
    public void addCoundiments() {
        System.out.println("添加糖");
    }
}
