package com.dsr.zookeeper.configcenter;

import com.dsr.zookeeper.DefaultWatcher;
import com.dsr.zookeeper.ZkConfig;
import com.dsr.zookeeper.configcenter.MyConfig;
import com.dsr.zookeeper.configcenter.WatchCallBack;
import com.dsr.zookeeper.util.ZkUtils;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.CountDownLatch;

public class Main {
    ApplicationContext context;

/*    @Before
    public void start(){

        context=new ClassPathXmlApplicationContext("context_redisTest.xml");
        defaultWatcher=context.getBean("defaultWatcher",DefaultWatcher.class);
    }*/
    @Test
    public void testLock() throws Exception {
        CountDownLatch latch=new CountDownLatch(1);
        DefaultWatcher defaultWatcher=new DefaultWatcher(latch);
        ZkUtils zkUtils=new ZkUtils();
        ZkConfig config=new ZkConfig();
        config.setAddress("192.168.220.111:2181,192.168.220.112:2181/confCenter");
        config.setTimeOut(3000);
        ZooKeeper zk=zkUtils.getZookeeper(config,defaultWatcher,latch);

        WatchCallBack watchCallBack=new WatchCallBack();
        MyConfig conf=new MyConfig();
        watchCallBack.getConfig(zk,conf);
        while(true){
            if(conf !=null){
                System.out.println(conf.getConfigMsg());
                Thread.sleep(10);
            }
        }
    }
}
