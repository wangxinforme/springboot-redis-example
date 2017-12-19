package com.wangxin;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nepxion.aquarius.idgenerator.RedisIdGeneratorApplication;
import com.nepxion.aquarius.idgenerator.redis.RedisIdGenerator;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisIdGeneratorApplication.class)
public class GetIdTest {

    @Autowired
    RedisIdGenerator redisIdGenerator;

    @Test
    public void getId() {
        try {
            String result = redisIdGenerator.nextUniqueId("idgenerater", "X-Y", 1, 8);// 从redis读取缓存的值
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
