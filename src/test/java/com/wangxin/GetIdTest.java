package com.wangxin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wangxin.redis.RedisService;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.wangxin" })
public class GetIdTest {

    @Autowired
    RedisService redisBaseDao;

    @Test
    public void getId() {
        try {
            redisBaseDao.set("a", "https://github.com/wangxinforme/springboot-redis-example");
            System.err.println(redisBaseDao.get("a"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
