package com.wangxin.idgenerator.redis.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

import com.wangxin.common.redis.handler.RedisHandler;

@Configuration
@Import({ com.wangxin.common.config.AquariusConfig.class })
public class RedisIdGeneratorConfig {
    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate() {
        return RedisHandler.createDefaultRedisTemplate();
    }
}