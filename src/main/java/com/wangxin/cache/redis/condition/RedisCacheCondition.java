package com.wangxin.cache.redis.condition;

import com.wangxin.cache.constant.CacheConstant;
import com.wangxin.common.condition.AquariusCondition;

public class RedisCacheCondition extends AquariusCondition {
    public RedisCacheCondition() {
        super(CacheConstant.CACHE_TYPE, CacheConstant.CACHE_TYPE_REDIS);
    }
}