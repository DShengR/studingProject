package day4;

import java.util.concurrent.locks.LockSupport;

public class CrossPrint2 {
    public static void main(String[] args) {
        Thread t1,t2=null;
        Object lock=new Object();
        t1=new Thread(()->{
            synchronized (lock){
                char c='A';
                for(int i=0;i<26;i++){
                    System.out.println((char)(c+i));
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2=new Thread(()->{
            synchronized (lock){
                for(int i=1;i<=26;i++){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                    lock.notify();
                }
            }
        });
        t2.start();
        t1.start();

    }
}
