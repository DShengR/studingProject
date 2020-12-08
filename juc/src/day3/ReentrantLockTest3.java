package day3;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest3 {
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLockTest3 lock3 = new ReentrantLockTest3();
        Thread t1=new Thread(lock3::m, "t1");
        Thread t2=new Thread(lock3::m, "t2");
        t1.start();
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // t1.interrupt();
        t2.interrupt();
    }

    public void m() {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"is interrupted");
        }
        try {
            if (lock.isLocked()) {
                System.out.println(Thread.currentThread().getName() + "获得锁");
                Thread.sleep(10000);
            } else
                System.out.println(Thread.currentThread().getName() + "获取锁失败");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
            }
        }
    }
}
