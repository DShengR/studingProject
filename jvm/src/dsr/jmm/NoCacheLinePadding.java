/*
package dsr.jmm;

public class NoCacheLinePadding {
    private static T[] t=new T[2];
    static{
        t[0]=new T();
        t[1]= new T();
    }

    public static void main(String[] args) throws InterruptedException {
        NoCacheLinePadding padding=new NoCacheLinePadding();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(long i=0;i<1000_0000l;i++){
                    t[0].i=i;
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(long i=0;i<1000_0000l;i++) {
                    t[1].i = i;
                }
            }
        });
        Long startTime=System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Long endTime=System.nanoTime();
        System.out.println((endTime-startTime)/100_0000);
    }
    static class T{
        private volatile Long i=0l;
    }
}
*/

package dsr.jmm;
import java.util.Random;

public class NoCacheLinePadding {
    private static class T {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(()->{
            for (long i = 0; i < 1000_0000L; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(()->{
            for (long i = 0; i < 1000_0000L; i++) {
                arr[1].x = i;
            }
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start)/100_0000);
    }
}
