package com.lh.stock.lhstock;

import com.lh.stock.lhstock.dao.UserDao;
import com.lh.stock.lhstock.service.impl.RedisCacheService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import redis.clients.jedis.JedisCluster;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LhStockApplication.class)
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
class LhStockApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    RedisCacheService redisCacheService;

    @Test
    void contextLoads() {

//        System.out.println(userDao.listUserInfo(0, 10));

        System.out.println(redisCacheService.getCacheByKey("mykey1:{100}"));
    }

}
