package day8.v1;

import com.lmax.disruptor.EventHandler;

/**
 * 数据消费者
 */
public class DisruptorEventHandler  implements EventHandler<DisruptorEvent> {
    @Override
    public void onEvent(DisruptorEvent event, long l, boolean b) throws Exception {
        Order order = event.getOrder();
        System.out.println(Thread.currentThread().getName()+"handle--"+order);
    }
}
