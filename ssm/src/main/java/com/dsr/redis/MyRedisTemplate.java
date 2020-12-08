package com.dsr.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class MyRedisTemplate {
    @Autowired
    private RedisTemplate redisTemplate;
    @Bean
    public RedisTemplate getMyRedisTemplate(){
      //  redisTemplate.setHashKeySerializer();
        return redisTemplate;
    }
}
