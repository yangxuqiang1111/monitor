package com.yangxq.monitor.test.templatePattern;

/**
 * Created by Yangxq on 2016/9/12.
 */
public abstract class AbstractBerverage implements Beverage {
    public void boilWater(String str) {
        boilWater(str);
    }

    public void pourInCup() {
        pourInCup();
    }

    public void brew() {
        brew();

    }

    public void addCoundiments() {
        addCoundiments();
    }

    public void create(String str) {
        boilWater(str);
        pourInCup();
        brew();
        addCoundiments();
    }
}
