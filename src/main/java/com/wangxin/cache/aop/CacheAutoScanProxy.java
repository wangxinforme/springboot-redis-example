package com.wangxin.cache.aop;


import java.lang.annotation.Annotation;

import org.aopalliance.intercept.MethodInterceptor;

import com.wangxin.cache.annotation.CacheEvict;
import com.wangxin.cache.annotation.CachePut;
import com.wangxin.cache.annotation.Cacheable;
import com.wangxin.matrix.aop.DefaultAutoScanProxy;
import com.wangxin.matrix.mode.ProxyMode;
import com.wangxin.matrix.mode.ScanMode;

// 通过全局拦截器实现对类头部注解的扫描和代理
public class CacheAutoScanProxy extends DefaultAutoScanProxy {
    private static final long serialVersionUID = 5099476398968133135L;

    @SuppressWarnings("rawtypes")
    private Class[] commonInterceptorClasses;

    @SuppressWarnings("rawtypes")
    private Class[] methodAnnotations;

    public CacheAutoScanProxy(String scanPackages) {
        super(scanPackages, ProxyMode.BY_METHOD_ANNOTATION_ONLY, ScanMode.FOR_METHOD_ANNOTATION_ONLY);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<? extends MethodInterceptor>[] getCommonInterceptors() {
        if (commonInterceptorClasses == null) {
            commonInterceptorClasses = new Class[] { CacheInterceptor.class };
        }

        return commonInterceptorClasses;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<? extends Annotation>[] getMethodAnnotations() {
        if (methodAnnotations == null) {
            methodAnnotations = new Class[] { Cacheable.class, CachePut.class, CacheEvict.class };
        }

        return methodAnnotations;
    }
}