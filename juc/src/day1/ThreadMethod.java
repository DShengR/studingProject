package day1;

public class ThreadMethod {
    public static void main(String[] args) {
        Task task=new Task();
        Thread t1=new Thread(task,"t1");
        Thread t2=new Thread(task,"t2");
        t1.start();
        t2.start();
    }
}
class Task implements Runnable{
    Object o=new Object();
    @Override
    public void run() {
        synchronized (o){
            if(Thread.currentThread().getName().equals("t1")){
                System.out.println("t1 yield");
                Thread.yield();
                System.out.println("t1 yield after");
            }else{

            }
        }
        System.out.println(Thread.currentThread());
    }
}
