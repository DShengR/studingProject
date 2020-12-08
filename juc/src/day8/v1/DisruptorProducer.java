package day8.v1;

import com.lmax.disruptor.EventProcessor;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.Sequence;

import java.nio.ByteBuffer;

public class DisruptorProducer {
  private RingBuffer<DisruptorEvent> ringBuffer;
  public DisruptorProducer(RingBuffer<DisruptorEvent> ringBuffer){
      this.ringBuffer=ringBuffer;
  }
  public void onData(Order order){
      long next = ringBuffer.next();
      try{
          DisruptorEvent event = ringBuffer.get(next);
          event.setOrder(order);
      }finally {
          ringBuffer.publish(next);
      }


  }
}
