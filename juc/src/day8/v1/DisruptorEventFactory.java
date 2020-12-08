package day8.v1;

import com.lmax.disruptor.EventFactory;
/*
数据生成工厂类
 */
public class DisruptorEventFactory implements EventFactory {
    @Override
    public DisruptorEvent newInstance() {
        return new DisruptorEvent();
    }
}
