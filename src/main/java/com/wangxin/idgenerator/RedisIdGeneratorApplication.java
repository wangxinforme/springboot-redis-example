package com.wangxin.idgenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.wangxin" })
public class RedisIdGeneratorApplication {
    private static final Logger LOG = LoggerFactory.getLogger(RedisIdGeneratorApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RedisIdGeneratorApplication.class, args);

        
    }
}