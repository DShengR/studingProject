package com.dsr.Observer.v1;

public class Main {
    public static void main(String[] args) {
        Child child=new Child();
        Dad dad=new Dad();
        Mom mom=new Mom();
        Dog dog =new Dog();
        child.wakeUp();
        while(true){
            if(child.isCry()){
                dad.hug("婴儿哭了");
                mom.feed("婴儿哭了");
                dog.wang("婴儿哭了");
            }
        }
    }
}
class Child{
    private boolean cry;
    public boolean isCry(){
        return cry;
    }
    public void wakeUp(){
        String e="婴儿哭了";
        this.cry=true;
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
