package com.dsr.zookeeper.util;

import com.dsr.zookeeper.ZkConfig;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZkUtils {
    private   ZooKeeper zooKeeper;
    public  ZooKeeper getZookeeper(ZkConfig config, Watcher defaultWatcher, CountDownLatch latch) throws Exception {
        zooKeeper=new ZooKeeper(config.getAddress(), config.getTimeOut(), defaultWatcher);
        latch.await();
        return zooKeeper;
    }
}
