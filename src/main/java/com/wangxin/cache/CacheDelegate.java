package com.wangxin.cache;


import org.aopalliance.intercept.MethodInvocation;

public interface CacheDelegate {
    // 新增缓存
    Object invokeCacheable(MethodInvocation invocation, String key, long expire) throws Throwable;

    // 更新缓存
    Object invokeCachePut(MethodInvocation invocation, String key, long expire) throws Throwable;

    // 清除缓存
    Object invokeCacheEvict(MethodInvocation invocation, String key, String name, boolean allEntries, boolean beforeInvocation) throws Throwable;
}