package day2;

import sun.misc.GC;
import sun.misc.Unsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class AtomicTest {
    private static AtomicInteger integer=new AtomicInteger(0);
    private static LongAdder longAdder=new LongAdder();
    static CountDownLatch latch=new CountDownLatch(100);
    public static void main(String[] args) {
        AtomicTest test=new AtomicTest();
        for(int i=0;i<100;i++){
            new Thread(test::increment1).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(integer.get());
    }
    public void increment1(){
        for(int i=0;i<2000;i++){
            integer.incrementAndGet();
        }
        latch.countDown();
    }
}
