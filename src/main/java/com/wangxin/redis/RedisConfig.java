package com.wangxin.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import com.wangxin.cache.CacheDelegate;
import com.wangxin.cache.redis.condition.RedisCacheCondition;
import com.wangxin.cache.redis.impl.RedisCacheDelegateImpl;
import com.wangxin.common.redis.handler.RedisHandler;

@Configuration
@ComponentScan(basePackages = { "com.wangxin.redis" })
public class RedisConfig {

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

    // @Bean(name = "redisTemplate")
    // public RedisTemplate<String, Object> redisTemplate() {
    // return RedisHandler.createDefaultRedisTemplate();
    // }

}
