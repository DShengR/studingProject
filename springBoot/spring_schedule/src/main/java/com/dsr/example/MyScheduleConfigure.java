package com.dsr.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyScheduleConfigure  {
    @Bean
    public TaskConfig taskConfig1(){
        TaskConfig config = new TaskConfig();
        config.setId(1);
        config.setName("name1");
        return  config;
    }
    @Bean
    public TaskConfig taskConfig2(){
        TaskConfig config = new TaskConfig();
        config.setId(2);
        config.setName("name2");
        return  config;
    }
}
