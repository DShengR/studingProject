package day4;

import java.util.LinkedList;

/**
 * 实现一个容器，提供add()和size()方法，写两个线程一个线程往容器中增加数据，另一个方法监控容器当容器个数到
 * 5时给出提示并退出
 * 使用wait notify实现
 */
public class MyContainerTest1 {
    LinkedList<Integer> list=new LinkedList<>();
    public void add(Integer i){
        if(list.size()+1==5){

        }
        list.add(i);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        MyContainerTest1 containerTest1=new MyContainerTest1();
        Object o=new Object();
        Thread t1=new Thread(()->{
            for(int i=0;i<10;i++){
                synchronized (o){
                    if(containerTest1.size()==5){
                        o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    containerTest1.add(i);
                    System.out.println("t1 add "+i);
                }
            }
        },"t1");
        Thread t2=new Thread(()->{
            synchronized (o){
                if(containerTest1.size()!=5){
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("容量到达了5-t2退出");
                o.notify();
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
