package com.dsr.example;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

//@Component
public class ExampleTask implements Runnable{
    //@Scheduled(initialDelay=1000,fixedDelay = 2000)
    public void execute(){
        System.out.println("task executed...");
    }
    private String task;
    public ExampleTask(String task){
        this.task=task;
    }
    @Override
    public void run() {
        //execute();
        System.out.println(Thread.currentThread().getName()+"执行---"+task);
    }

}
