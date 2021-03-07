package com.dsr.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadFactory;
@Component
public class MyTaskSchedule implements ApplicationListener {
    @Autowired
    private List<TaskConfig> taskConfigs;
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        ThreadPoolTaskScheduler scheduler = createTaskSchedule(2,"amazonorder");
        scheduler.schedule(new ExampleTask("task1"), new CronTrigger("0/5 * * * * ?"));
        scheduler.schedule(new ExampleTask("task2"), new CronTrigger("0/5 * * * * ?"));
    }
    private ThreadPoolTaskScheduler createTaskSchedule(int poolSize, String name){
        ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
        executor.setPoolSize(poolSize);
        executor.setThreadNamePrefix(name);
        executor.initialize();
        System.out.println("scheduledExecutor"+executor.getScheduledExecutor());
        System.out.println("scheduledThreadPoolExecutor"+executor.getScheduledThreadPoolExecutor());
        return executor;
    }

}
