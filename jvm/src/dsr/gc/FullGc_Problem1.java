package dsr.gc;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FullGc_Problem1 {
    static ScheduledExecutorService scheduledExecutor= Executors.newScheduledThreadPool(50, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"Mytest");
        }
    });
    public static void main(String[] args) throws InterruptedException {
        for(;;){
            modelFit();
            Thread.sleep(1000);
        }
    }
    private static void modelFit(){
        List<CardInfo> list=getAllCards();
        for(CardInfo info:list){
            scheduledExecutor.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    info.m();
                }
            }, 2, 3, TimeUnit.SECONDS);
        }
    }
    private static List<CardInfo> getAllCards(){
        List<CardInfo> list=new ArrayList<>();
        for(int i=0;i<100;i++){
            CardInfo info=new CardInfo("dsr","111111111111111111",25,new BigDecimal(1000));
            list.add(info);
        }
        return list;
    }
    private  static class CardInfo{
        private String name;
        private String cardNo;
        private Integer age;
        private BigDecimal amt;

        public CardInfo(String name, String cardNo, Integer age, BigDecimal amt) {
            this.name = name;
            this.cardNo = cardNo;
            this.age = age;
            this.amt = amt;
        }
        private void m(){}
    }
    private class RunnableTask implements Runnable{
        private CardInfo info;
        public void setInfo(CardInfo info){
            this.info=info;
        }
        @Override
        public void run() {
            info.m();
        }
    }
}

