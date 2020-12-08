package day3;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest1 {
    static CountDownLatch latch;

    public static void main(String[] args) {
        latch=new CountDownLatch(100);
        CountDownLatchTest1 test1=new CountDownLatchTest1();
        for(int i=0;i<100;i++){
            new Thread(test1::m).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void m(){
        latch.countDown();
    }
}
