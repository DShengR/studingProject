package day3;

import java.util.concurrent.Semaphore;

public class SemaphoreTest1 {
    static Semaphore semaphore=new Semaphore(1);
    public static void main(String[] args) {
        for(int i=0;i<12;i++){
            new Thread(()->m()).start();
        }
    }
    public static void m(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"--acquired");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}
