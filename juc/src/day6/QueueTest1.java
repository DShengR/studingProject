package day6;

import java.util.concurrent.*;

public class QueueTest1 {
    public static void main(String[] args) {
        LinkedBlockingQueue linkedBlockingQueue=new LinkedBlockingQueue();
        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(10);
        DelayQueue delayQueue=new DelayQueue();
        SynchronousQueue synchronousQueue=new SynchronousQueue();
    }
}
