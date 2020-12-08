package day4;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

/**
 * 实现一个容器，提供add()和size()方法，写两个线程一个线程往容器中增加数据，另一个方法监控容器当容器个数到
 * 5时给出提示并退出
 * 使用两个countdownlatch实现
 */
public class MyContainerTest2 {
    LinkedList<Integer> list=new LinkedList<>();
    public void add(int i){
        list.add(i);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        MyContainerTest2 test2=new MyContainerTest2();
        CountDownLatch latch1=new CountDownLatch(1);
        CountDownLatch latch2=new CountDownLatch(1);
        Thread t1=new Thread(()->{
            for(int i=0;i<10;i++){
                if(test2.size()==5){
                    latch1.countDown();
                    try {
                        latch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                test2.add(i);
                System.out.println("t1 add "+i);
            }
        });
        Thread t2=new Thread(()->{
            if(test2.size()!=5){
                try {
                    latch1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("容量到达了5-t2退出");
            latch2.countDown();
        });
        t1.start();
        t2.start();
    }
}
