package day7;

import java.util.concurrent.*;

public class ExecutorTest1 {
    public static void main(String[] args) {
        Executor executor;
        ExecutorService service= Executors.newCachedThreadPool();
        Future future=service.submit(()->{return "ddd";});
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
