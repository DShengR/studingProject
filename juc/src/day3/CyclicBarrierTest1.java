package day3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest1{
    CyclicBarrier barrier=new CyclicBarrier(50,()->{ System.out.println(Thread.currentThread().getName()+"---都到达了"); });

    public static void main(String[] args) {
        CyclicBarrierTest1 test1=new CyclicBarrierTest1();
        for(int i=0;i<100;i++){
            new Thread(test1::m,"t-"+i).start();
        }
    }
    public void m(){
        try {
            System.out.println(Thread.currentThread().getName()+"到达");
            int i=barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
