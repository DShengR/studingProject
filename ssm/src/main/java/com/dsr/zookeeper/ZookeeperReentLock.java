package com.dsr.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;


public class ZookeeperReentLock implements Watcher, AsyncCallback.StringCallback, AsyncCallback.ChildrenCallback {
    private ZooKeeper zk;
    private String rootPath="/lock";
    private CountDownLatch latc=new CountDownLatch(1);
    String threadName;
    String lockName;

    public void lock() throws InterruptedException {
        zk.create(rootPath, "lock".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL, this,"");
        latc.await();
    }
    public void unlock(){
        try {
            zk.delete("/"+lockName,0);
            System.out.println(threadName+"--释放锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            System.out.println(lockName);
            e.printStackTrace();
        }
    }

    //create lock
    @Override
    public void processResult(int i, String s, Object o, String name) {
        System.out.println(threadName+"create :"+name);
        lockName=name.substring(1);
        zk.getChildren("/", false, this,"");
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }
    public void setThreadName(String name){
        this.threadName=name;
    }

    //get children
    @Override
    public void processResult(int rc, String path, Object ctx, List<String> children) {
       // System.out.println(children);
        if(children !=null){
            Collections.sort(children);
            int index = children.indexOf(lockName);
            if(index <=0){
                System.out.println(threadName+"--抢的锁");
                latc.countDown();
            }else{
                System.out.println(threadName+"监控："+"/" + children.get(index-1));
                try {
                    Stat exists = zk.exists("/" + children.get(index - 1), this);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
       // latc.countDown();
    }


    @Override
    public void process(WatchedEvent event) {
        System.out.println(threadName+"--监控被调用");
        Event.EventType type = event.getType();
        switch (type) {
            case NodeDeleted:
                System.out.println(threadName+"--获得锁");
                latc.countDown();
                break;
        }
    }
}
