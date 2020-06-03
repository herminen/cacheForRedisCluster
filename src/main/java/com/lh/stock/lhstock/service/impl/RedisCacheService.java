package com.lh.stock.lhstock.service.impl;

import com.lh.stock.lhstock.service.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 14:24
 */
@Service("redisCacheService")
public class RedisCacheService implements ICacheService {

    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public String getCacheByKey(String key) {
        return jedisCluster.get(key);
    }
}
