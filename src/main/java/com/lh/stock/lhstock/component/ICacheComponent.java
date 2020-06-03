package com.lh.stock.lhstock.component;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 19:34
 */
public interface ICacheComponent {
    /**
     * 查询缓存
     * @param key
     * @return
     */
    String getCacheByKey(String key);

    /**
     * 删除缓存
     * @param key
     * @return
     */
    boolean deleteCacheByKey(String key);
}
