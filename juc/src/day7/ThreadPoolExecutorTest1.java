package day7;

import java.util.concurrent.*;

import static java.util.concurrent.ThreadPoolExecutor.*;

public class ThreadPoolExecutorTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int[] i = {1};
        ThreadPoolExecutor executor;
        executor = new ThreadPoolExecutor(2,3,60, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5),new ThreadFactory(){

            @Override
            public Thread newThread(Runnable r) {

                return new Thread(r,"Thread--"+(i[0]++));
            }
        },new ThreadPoolExecutor.AbortPolicy());
        System.out.println(executor.getPoolSize());

        Future<?> submit = executor.submit(() -> {return 1;
        });
        System.out.println("future get:"+submit.get());
        executor.submit(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(executor.getPoolSize());
        executor.submit(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(executor.getPoolSize());
        executor.submit(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(executor.getPoolSize());

        executor.submit(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.submit(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.submit(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.submit(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.submit(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.submit(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
