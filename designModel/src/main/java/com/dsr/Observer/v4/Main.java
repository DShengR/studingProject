package com.dsr.Observer.v4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Child child=new Child();
        child.addObserver(new Dad());
        child.addObserver(new Mom());
        child.addObserver(new Dog());
        child.wakeUp();
    }
}
class Child implements ObserAble{
    List<Observer> observers=new ArrayList<Observer>();
    public void wakeUp(){
        String e="婴儿哭了";
        WakeEvent event=new WakeEvent(System.currentTimeMillis(),"cry",e);
        notifyObserver(event);
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObserver(WakeEvent e) {
        for(Observer o:observers){
            o.actionOnWakeUp(e);
        }
    }
}
interface  ObserAble{
    void addObserver(Observer o);
    void notifyObserver(WakeEvent e);
}
interface Observer{
    void actionOnWakeUp(WakeEvent e);
}
class WakeEvent{
    long time;
    String type;
    String msg;
    //.....
    public WakeEvent(long time, String type, String msg) {
        this.time = time;
        this.type = type;
        this.msg = msg;
    }
}
/**
 * 观察者1
 */
class Dad implements Observer{
    public void hug(WakeEvent e){
        System.out.println(e+",爸爸抱抱");
    }
    @Override
    public void actionOnWakeUp(WakeEvent e) {
        hug(e);
    }
}
/**
 * 观察者2
 */
class Mom implements Observer{
    public void feed(WakeEvent e){
        System.out.println(e+",妈妈喂食");
    }

    @Override
    public void actionOnWakeUp(WakeEvent e) {
        feed(e);
    }
}
/**
 * 观察者3
 */
class Dog implements Observer{
    public void  wang(WakeEvent e){
        System.out.println(e+",小狗汪汪汪叫");
    }

    @Override
    public void actionOnWakeUp(WakeEvent e) {
        wang(e);
    }
}

