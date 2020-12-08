package day4;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProduceAndConsumer2 {
    LinkedList<Integer> list=new LinkedList<>();
    ReentrantLock lock=new ReentrantLock();
    Condition consumer=lock.newCondition();
    Condition produce=lock.newCondition();
    int max=10;
    public void put(int i){
        lock.lock();
        while(list.size()==max){
            try {
                produce.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(i);
        consumer.signalAll();
        lock.unlock();
    }
    public int get(){
        lock.lock();
        while(list.size()==0){
            try {
                consumer.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int value=list.removeFirst();
        produce.signalAll();
        lock.unlock();
        return value;
    }



    public static void main(String[] args) {
        ProduceAndConsumer1 pc=new ProduceAndConsumer1();
        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<10;j++){
                    pc.put(j);
                    System.out.println(Thread.currentThread().getName()+"put--"+j);
                }
            },"produce--"+i).start();
        }

        for(int i=0;i<12;i++){
            new Thread(()->{
                for(int j=0;j<10;j++){
                    int value=pc.get();
                    System.out.println(Thread.currentThread().getName()+"get--"+value);
                }
            },"consumer--"+i).start();
        }
    }
}
