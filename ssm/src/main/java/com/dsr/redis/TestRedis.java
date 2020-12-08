package com.dsr.redis;

import org.aspectj.weaver.ast.Var;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TestRedis {
    ApplicationContext context;
    @Before
    public void start(){
        context=new ClassPathXmlApplicationContext("context_redisTest.xml");
    }
    @Test
    public void test(){
        RedisTemplate redisTemplate = context.getBean("redisTemplate", RedisTemplate.class);
        StringRedisTemplate stringRedisTemplate=context.getBean("stringRedisTemplate",StringRedisTemplate.class);

        //redisTemplate.opsForValue().set("duan", "shengrong1");
        stringRedisTemplate.opsForValue().set("duan1", "test");

        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
      //  Boolean aBoolean = connection.hSet("hash".getBytes(), "name".getBytes(), "段盛荣".getBytes());
        Map<byte[],byte[]> map=new HashMap<>();
        map.put("age".getBytes(), "10".getBytes());
        map.put("englishname".getBytes(), "dsr".getBytes());
        map.put("name".getBytes(), "段盛荣".getBytes(Charset.forName("UTF-8")));
        connection.hMSet("hash".getBytes(),map);

        stringRedisTemplate.opsForHash().put("hash", "name","段盛荣");
        Object o = stringRedisTemplate.opsForHash().get("hash", "name");
        System.out.println("stringRedisTem:"+o);
        Object o1 = redisTemplate.opsForHash().get("hash", "name");
        System.out.println("redisTem:"+o1);
        /**
         * list
         */
    }
    @Test
    public void test1(){
        RedisTemplate redisTemplate = context.getBean("redisTemplate", RedisTemplate.class);
        StringRedisTemplate stringRedisTemplate=context.getBean("stringRedisTemplate",StringRedisTemplate.class);
        stringRedisTemplate.opsForValue().set("stringTest", "111");
        System.out.println(stringRedisTemplate.opsForValue().get("stringTest"));
        stringRedisTemplate.opsForValue().increment("stringTest");
        stringRedisTemplate.opsForValue().append("stringTest","22");
        System.out.println(stringRedisTemplate.opsForValue().get("stringTest",0,2));
        /**
         * list
         */
        stringRedisTemplate.opsForList().leftPush("listTest","1");
        stringRedisTemplate.opsForList().leftPushAll("listTest", "a","2","b");
        System.out.println(stringRedisTemplate.opsForList().range("listTest",0,-1));
        System.out.println(stringRedisTemplate.opsForList().leftPop("listTest"));
        System.out.println(stringRedisTemplate.opsForList().rightPop("listTest"));

        /**
         * hash
         */
        Map<String,String> map=new HashMap<>();
        map.put("age", "10");
        map.put("englishname", "dsr");
        map.put("name", "段盛荣");
        stringRedisTemplate.opsForHash().putAll("my",map);
        System.out.println(stringRedisTemplate.opsForHash().keys("my"));
        System.out.println(stringRedisTemplate.opsForHash().values("my"));
        System.out.println(stringRedisTemplate.opsForHash().entries("my"));

        /**
         * set
         */
        stringRedisTemplate.opsForSet().add("setTest","1","a","2","a");
        stringRedisTemplate.opsForSet().add("setTest2","1","a","3","b");
        System.out.println(stringRedisTemplate.opsForSet().members("setTest"));
        System.out.println(stringRedisTemplate.opsForSet().difference("setTest","setTest2"));
        System.out.println(stringRedisTemplate.opsForSet().difference("setTest2","setTest"));
        System.out.println(stringRedisTemplate.opsForSet().intersect("setTest","setTest2"));
        System.out.println(stringRedisTemplate.opsForSet().union("setTest2","setTest"));

        /**
         * sorted_set
         */
        stringRedisTemplate.opsForZSet().add("zset","apple",60);
        stringRedisTemplate.opsForZSet().add("zset","bana",72.5);
        stringRedisTemplate.opsForZSet().add("zset","orange",60);
        System.out.println(stringRedisTemplate.opsForZSet().range("zset",0,-1));
        System.out.println(stringRedisTemplate.opsForZSet().rangeByScore("zset",50, 60.5));
    }
    @Test
    public void testMore() throws InterruptedException {
        StringRedisTemplate stringRedisTemplate=context.getBean("stringRedisTemplate",StringRedisTemplate.class);
        stringRedisTemplate.setEnableTransactionSupport(true);
        stringRedisTemplate.watch("count");
        stringRedisTemplate.multi();
        String count = stringRedisTemplate.opsForValue().get("count");
        stringRedisTemplate.opsForValue().set("count222", "2222");
        stringRedisTemplate.opsForValue().increment("count");
        System.out.println("exec前："+count+",");
        List<Object> exec = stringRedisTemplate.exec();
        System.out.println(exec);
        for(Object o:exec){
            System.out.println(o);
        }

    }
    @Test
    public void test2(){
        StringRedisTemplate stringRedisTemplate=context.getBean("stringRedisTemplate",StringRedisTemplate.class);
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("count", "0");
        int size=100;
        CountDownLatch lath=new CountDownLatch(size);
        IncrTask task=new IncrTask(lath, stringStringValueOperations);
        for(int i=0;i<size;i++){
            Thread t=new Thread(task);
            t.start();
        }
        try {
            lath.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(stringStringValueOperations.get("count"));
    }
    class IncrTask implements Runnable{
        private int count=0;
        private CountDownLatch latch;
        ValueOperations<String, String> stringStringValueOperations;
        RedisTemplate redisTemplate = context.getBean("redisTemplate", RedisTemplate.class);
        public IncrTask(CountDownLatch latch,ValueOperations<String, String> stringStringValueOperations){
            this.latch=latch;
            this.stringStringValueOperations=stringStringValueOperations;
        }
        @Override
        public void run() {
            RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
            for(int i=0;i<1000;i++){
                //stringStringValueOperations.increment("count");
                connection.incr("count".getBytes());
            }
            latch.countDown();
        }
    }
}
