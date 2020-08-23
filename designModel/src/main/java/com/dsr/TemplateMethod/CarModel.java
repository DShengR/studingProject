package com.dsr.TemplateMethod;

public abstract  class CarModel {
    final public void run(){
        start();
        alarm();
        engineBoom();
        stop();
    }
    protected abstract  void start();
    protected abstract void alarm();
    protected abstract void engineBoom();
    protected abstract void stop();
}
