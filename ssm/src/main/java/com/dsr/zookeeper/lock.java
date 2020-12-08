package com.dsr.zookeeper;

import com.dsr.zookeeper.util.ZkUtils;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class lock {
    @Test
    public void test() throws Exception {
        CountDownLatch latch=new CountDownLatch(1);
        DefaultWatcher defaultWatcher=new DefaultWatcher(latch);
        ZkUtils zkUtils=new ZkUtils();
        ZkConfig config=new ZkConfig();
        config.setAddress("192.168.220.111:2181,192.168.220.112:2181/lock");
        config.setTimeOut(3000);
        final ZooKeeper zk=zkUtils.getZookeeper(config,defaultWatcher,latch);
        for(int i=0;i<10;i++){
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    ZookeeperReentLock lock=new ZookeeperReentLock();
                    lock.setThreadName(Thread.currentThread().getName());
                    lock.setZk(zk);
                    try {
                        lock.lock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.unlock();
                }
            }, "Thread--" + i);
            t.start();
        }
        while(true){}
    }
}
