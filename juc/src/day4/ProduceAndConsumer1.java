package day4;

import java.util.LinkedList;

public class ProduceAndConsumer1 {
    LinkedList<Integer> list=new LinkedList<>();
    int max=10;
    public synchronized void put(Integer i){
        while(list.size()==max){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(i);
        notifyAll();
    }
    public synchronized  int get(){
        while(list.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int value=list.removeFirst();
        notifyAll();
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
