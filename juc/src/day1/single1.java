package day1;

import java.util.concurrent.atomic.AtomicInteger;

public class single1 {
    Object o=new Object();
    int count=0;
    AtomicInteger integer=new AtomicInteger();
    public void m(){
        integer.incrementAndGet();
        integer.getAndIncrement();
        count++;
    }
}
