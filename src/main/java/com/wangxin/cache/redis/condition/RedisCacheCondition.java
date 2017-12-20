package com.wangxin.cache.redis.condition;

import com.wangxin.common.condition.AquariusCondition;

public class RedisCacheCondition extends AquariusCondition {

    public static final String CACHE_TYPE = "cacheType";
    public static final String CACHE_TYPE_REDIS = "redisCache";

    public RedisCacheCondition() {
        super(CACHE_TYPE, CACHE_TYPE_REDIS);
    }
}