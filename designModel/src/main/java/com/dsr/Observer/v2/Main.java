package com.dsr.Observer.v2;

public class Main {
    public static void main(String[] args) {
        Child child=new Child();
        child.wakeUp();
    }
}
class Child{
    Dad dad=new Dad();
    Mom mom=new Mom();
    Dog dog=new Dog();
    public void wakeUp(){
        String e="婴儿哭了";
        dad.hug(e);
        mom.feed(e);
        dog.wang(e);
    }
}
/**
 * 观察者1
 */
class Dad{
    public void hug(String e){
        System.out.println(e+",爸爸抱抱");
    }
}
/**
 * 观察者2
 */
class Mom{
    public void feed(String e){
        System.out.println(e+",妈妈喂食");
    }
}
/**
 * 观察者3
 */
class Dog{
    public void  wang(String e){
        System.out.println(e+",小狗汪汪汪叫");
    }
}
