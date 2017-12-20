package com.wangxin.cache.redis.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

import com.wangxin.cache.CacheDelegate;
import com.wangxin.cache.redis.condition.RedisCacheCondition;
import com.wangxin.cache.redis.impl.RedisCacheDelegateImpl;
import com.wangxin.common.redis.handler.RedisHandler;

@Configuration
@Import({ com.wangxin.common.config.AquariusConfig.class })
public class RedisCacheConfig {
    @Bean(name = "redisCacheDelegate")
    @Conditional(RedisCacheCondition.class)
    public CacheDelegate redisCacheDelegate() {
        return new RedisCacheDelegateImpl();
    }

    @Bean(name = "redisTemplate")
    @Conditional(RedisCacheCondition.class)
    public RedisTemplate<String, Object> redisTemplate() {
        return RedisHandler.createDefaultRedisTemplate();
    }
}