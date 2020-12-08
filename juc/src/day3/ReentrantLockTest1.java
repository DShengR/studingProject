package day3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest1 {
    ReentrantLock lock=new ReentrantLock();
    static int count=0;
    static CountDownLatch latch=new CountDownLatch(100);
    public static void main(String[] args) {
        ReentrantLockTest1 reentrantLock=new ReentrantLockTest1();
        for(int i=0;i<100;i++){
            new Thread(reentrantLock:: increment).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
    public void increment(){
        lock.lock();
        try{
            for(int i=0;i<1000;i++)
                count++;
            latch.countDown();
        }catch (Exception e){
            throw e;
        }finally {
            lock.unlock();
        }
    }
}

