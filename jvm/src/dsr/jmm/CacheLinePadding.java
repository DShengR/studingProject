
package dsr.jmm;

public class CacheLinePadding {
    private static class Padding{
        public volatile long p1, p2, p3, p4, p5, p6, p7;
    }
    private static class T extends  Padding{
        public volatile long X=0L;
    }
    public static T[] arr = new T[2];
    static {
        arr[0] = new T();
        arr[1] = new T();
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(long i=0;i<1000_0000l;i++){
                    arr[0].X=i;
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(long i=0;i<1000_0000l;i++){
                    arr[1].X=i;
                }
            }
        });
        final long start = System.nanoTime();
        //t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println((System.nanoTime() - start)/100_0000);
    }
}
