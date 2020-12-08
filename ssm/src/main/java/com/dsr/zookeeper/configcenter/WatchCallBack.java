package com.dsr.zookeeper.configcenter;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

public class WatchCallBack implements Watcher , AsyncCallback.StatCallback , AsyncCallback.DataCallback {
    private String watchPath="/config";
    private MyConfig config;
    private ZooKeeper zk;
    private CountDownLatch latch=new CountDownLatch(1);
    @Override
    public void process(WatchedEvent watchedEvent) {
        Event.EventType type = watchedEvent.getType();
        switch (type) {
            case None:
                break;
            case NodeCreated:
                System.out.println(watchPath+"---创建了");
                zk.getData(watchPath,this,this,"");
                break;
            case NodeDeleted:
                System.out.println(watchPath+"---删除了");
                config.setConfigMsg("");
                break;
            case NodeDataChanged:
                System.out.println(watchPath+"---修改了");
                zk.getData(watchPath,this,this,"");
                break;
        }
    }

    @Override
    public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {
        if(bytes !=null){
            config.setConfigMsg(new String(bytes));
            latch.countDown();
        }
    }
    @Override
    public void processResult(int i, String s, Object o, Stat stat) {
        if(stat != null){
            zk.getData(watchPath,this,this,"");
        }
    }

    public void getConfig(ZooKeeper zooKeeper,MyConfig conf){
        this.zk=zooKeeper;
        this.config=conf;
        zooKeeper.exists(watchPath,this,this,"");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MyConfig getConfig() {
        return config;
    }

    public void setConfig(MyConfig config) {
        this.config = config;
    }

    public ZooKeeper getZk() {
        return zk;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }
}
