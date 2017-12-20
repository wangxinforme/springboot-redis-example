package com.wangxin.cache.aop;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.wangxin.cache.constant.CacheConstant;

@Component("cacheAop")
public class CacheAop {
    @Value("${" + CacheConstant.CACHE_SCAN_PACKAGES + "}")
    private String scanPackages;

    @Bean("cacheAutoScanProxy")
    public CacheAutoScanProxy cacheAutoScanProxy() {
        return new CacheAutoScanProxy(scanPackages);
    }
}