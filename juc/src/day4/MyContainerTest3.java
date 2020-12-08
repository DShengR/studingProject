package day4;

import java.util.LinkedList;
import java.util.concurrent.locks.LockSupport;
/**
 * 实现一个容器，提供add()和size()方法，写两个线程一个线程往容器中增加数据，另一个方法监控容器当容器个数到
 * 5时给出提示并退出
 * 使用LockSupport实现
 */
public class MyContainerTest3 {
    LinkedList<Integer> list=new LinkedList<>();
    public void add(int i){
        list.add(i);
    }
    public int size(){
        return list.size();
    }
    static Thread t1,t2 = null;
    public static void main(String[] args) {

        MyContainerTest3 test3=new MyContainerTest3();
        t1=new Thread(()->{
            for (int i=0;i<10;i++){
                if(test3.size()==5){
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
                test3.add(i);
                System.out.println("t1 add "+i);
            }
        });
        t2=new Thread(()->{
            if(test3.size()!=5){
                LockSupport.park();
            }
            System.out.println("容量到达了5-t2退出");
            LockSupport.unpark(t1);
        });
        t1.start();
        t2.start();
    }
}
