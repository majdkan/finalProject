package com.customerService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;

@Configuration
public class JedisConfig {

    @Autowired
    RedisDetailsConfig redisDetailsConfig;

    @Bean
    public JedisPooled initiateJedis(){
        return new JedisPooled(redisDetailsConfig.getHost(), Math.toIntExact(redisDetailsConfig.getPort()));
    }
}
