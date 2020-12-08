package com.dsr.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

public class DefaultWatcher implements Watcher {
    private CountDownLatch latch;
    public DefaultWatcher(CountDownLatch latch){
        this.latch=latch;
    }
    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        Event.KeeperState state = watchedEvent.getState();
        Event.EventType type = watchedEvent.getType();
        switch (state){
            case Disconnected:
                break;
            case SyncConnected:
                latch.countDown();
                System.out.println("connected ok...");
                break;
            case AuthFailed:
                break;
            case Closed:
                break;
        }
    }
}
