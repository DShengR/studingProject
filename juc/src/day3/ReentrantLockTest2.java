package day3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest2 {
    ReentrantLock lock=new ReentrantLock();
    public static void main(String[] args) {
        ReentrantLockTest2 test2=new ReentrantLockTest2();
        new Thread(test2::m2,"t1").start();
        new Thread(test2::m2,"t2").start();
    }
    public void m() {
        boolean flag = lock.tryLock();
        try {
            if (flag) {
                System.out.println(Thread.currentThread().getName() + "获得锁");
                Thread.sleep(1000);
            } else
                System.out.println(Thread.currentThread().getName() + "获取锁失败");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag)
                lock.unlock();
        }
    }
    public void m2() {
        boolean flag= false;
        try {
            flag = lock.tryLock(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            if(flag) {
                System.out.println(Thread.currentThread().getName() + "获得锁");
                Thread.sleep(1000);
            }
            else
                System.out.println(Thread.currentThread().getName()+"获取锁失败");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(flag)
                lock.unlock();
        }

    }
}
