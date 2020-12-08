package day3;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest1 {
    String str="start";
    static ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    static ReentrantLock lock=new ReentrantLock();

    public static void main(String[] args) {
        ReentrantReadWriteLock.ReadLock readLock=readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock=readWriteLock.writeLock();
        ReadWriteLockTest1 test1=new ReadWriteLockTest1();
        for(int i=0;i<12;i++){
            new Thread(()->{read(readLock);}).start();
        }
        for(int i=0;i<2;i++){
            new Thread(()->{write(writeLock,"");}).start();
        }
    }
    public static void read(Lock lock){
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"--read over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public static void write(Lock lock ,String str){
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"--write over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
