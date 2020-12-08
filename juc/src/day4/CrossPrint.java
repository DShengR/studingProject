package day4;

import java.util.concurrent.locks.LockSupport;

public class CrossPrint {
    static Thread t1,t2=null;
    public static void main(String[] args) {
        t1=new Thread(()->{
            char c='A';
            for(int i=0;i<26;i++){
                System.out.println((char)(c+i));
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });
        t2=new Thread(()->{
            for(int i=1;i<=26;i++){
                LockSupport.park();
                System.out.println(i);
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
    }
}
