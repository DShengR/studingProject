package com.dsr.redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestSentinel {
    StringRedisTemplate stringRedisTemplate;
    @Before
    public void start(){
        ApplicationContext context=new ClassPathXmlApplicationContext("context_redisTest.xml");
        stringRedisTemplate=context.getBean("stringRedisTemplate",StringRedisTemplate.class);
    }
    @Test
    public void testSentinel() throws InterruptedException {
        RedisReentLock lock=new RedisReentLock();
        while(true){
            String count = stringRedisTemplate.opsForValue().get("needkey");
            if(count==null){
                boolean isLocked = lock.lock();
                if(isLocked){
                    try{
                        String s = qryFromDb();
                        stringRedisTemplate.opsForValue().set("needkey", s);
                    }finally {
                        lock.unlock();
                        break;
                    }
                }else{
                    Thread.sleep(1000);
                }
            }
        }


    }
    @Test
    public void testRedisLock() throws InterruptedException {
        Task task=new Task();
        List<Thread> threads=new ArrayList<>();

        for(int i=0;i<10;i++){
            Thread t=new Thread(task);
            t.start();
            threads.add(t);
        }
        for(Thread t:threads){
            t.join();
        }
        System.out.println(task.count);
    }
    class Task implements Runnable{
        private int count=0;
        RedisReentLock lock= new RedisReentLock();
        @Override
        public void run() {


            for(int i=0;i<100;i++){
                while(true){
                    boolean flag=lock.lock();
                    if(flag){
                        break;
                    }else{
/*                        try {
                            Thread.sleep((long)(Math.random()*10));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                    }
                }
                count++;
                System.out.println(Thread.currentThread().getName()+"---"+count);
                lock.unlock();
            }

        }
    }

    public String qryFromDb(){
        return "value from db";
    }
    class RedisReentLock{
        private final String lock="lock";
        private ThreadLocal<Integer> local=new ThreadLocal(){
            @Override
            protected Object initialValue() {
                return 0;
            }
        };
        public boolean lock(){
            int state=local.get();
            if(state>0){
                local.set(++state);
                return true;
            }else{
                Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent(lock, "locked", 5l, TimeUnit.SECONDS);
                if(!aBoolean){
                    return false;
                }
                local.set(++state);
            }
            return true;
        }
        public void unlock(){
            int state=local.get();
            if(state>0){
                local.set(--state);
            }else{
                stringRedisTemplate.delete(lock);
            }
        }
    }
}
