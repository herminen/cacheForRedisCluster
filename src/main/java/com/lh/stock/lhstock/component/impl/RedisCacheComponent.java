package com.lh.stock.lhstock.component.impl;

import com.lh.stock.lhstock.component.ICacheComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 19:35
 */
@Component("redisCacheComponent")
public class RedisCacheComponent implements ICacheComponent {
    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public String getCacheByKey(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public boolean deleteCacheByKey(String key) {
        return jedisCluster.del(key) > 0;
    }

    public String setCacheByKey(String key, String value){
        return jedisCluster.set(key,value);
    }
}
