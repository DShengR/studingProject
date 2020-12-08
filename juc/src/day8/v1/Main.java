package day8.v1;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import com.sun.org.apache.xerces.internal.dom.ProcessingInstructionImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Main main=new Main();
        main.testDisruptor();
    }
    public void testDisruptor(){
        Integer ringBufferSize=16;
        DisruptorEventFactory eventFactory=new DisruptorEventFactory();
        Disruptor<DisruptorEvent> disruptor=new Disruptor<DisruptorEvent>(eventFactory, ringBufferSize,new MyThreadFactory());

        disruptor.handleEventsWith(new DisruptorEventHandler(),new DisruptorEventHandler(),new DisruptorEventHandler());

        RingBuffer<DisruptorEvent> ringBuffer=disruptor.getRingBuffer();

        DisruptorProducer producer=new DisruptorProducer(ringBuffer);

        disruptor.start();
        for(int i=0;i<20;i++){
            Order order=new Order(i,"payee"+i, "payer"+i, new BigDecimal(i*10),new Date());
            producer.onData(order);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class MyThreadFactory implements  ThreadFactory{
        private AtomicInteger index=new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"disruptor-"+index.getAndIncrement());
        }
    }
}
