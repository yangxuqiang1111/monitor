package com.yangxq.monitor.test.templatePattern;

/**
 * Created by Yangxq on 2016/9/12.
 */
public class TestTemplatePattern {
    public static void main(String[] args) {
        Beverage coffee=new Coffee();
        coffee.create("coffee");

        System.out.println("--------------------------");
        Beverage tea=new Tea();
        tea.create("tea");
    }
}
