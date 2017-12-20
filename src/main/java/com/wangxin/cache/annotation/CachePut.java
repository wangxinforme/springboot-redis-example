package com.wangxin.cache.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CachePut {
    /**
     * 缓存名字
     */
    String name() default "";

    /**
     * 缓存Key
     */
    String key() default "";

    /**
     * 过期时间
     * 单位毫秒，默认60秒
     */
    long expire() default 60000L;
}