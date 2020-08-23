package com.dsr.TemplateMethod;

public class BmwCar extends CarModel {
    @Override
    public void start() {
        System.out.println("BMW 发动");
    }
    @Override
    public void alarm() {
        System.out.println("BMW 鸣笛");
    }
    @Override
    public void engineBoom() {
        System.out.println("BMW 引擎声");
    }
    @Override
    public void stop() {
        System.out.println("BMW 停车");
    }
}
