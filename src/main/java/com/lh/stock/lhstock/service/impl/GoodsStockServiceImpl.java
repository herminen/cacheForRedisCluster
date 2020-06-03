package com.lh.stock.lhstock.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lh.stock.lhstock.component.ICacheComponent;
import com.lh.stock.lhstock.dao.GoodsStockDao;
import com.lh.stock.lhstock.po.GoodsStockPO;
import com.lh.stock.lhstock.service.IGoodsStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 19:37
 */
@Service
public class GoodsStockServiceImpl implements IGoodsStockService {

    @Autowired
    private GoodsStockDao goodsStockDao;

    @Autowired
    @Qualifier("jedisCacheComponent")
    private ICacheComponent redisCacheCompoent;

    @Override
    public boolean updateGoodsStockById(GoodsStockPO goodsStockPO) {
        //删除cache
        redisCacheCompoent.deleteCacheByKey(goodsStockPO.getRedisStockKey());
        //更新数据库
        return goodsStockDao.updateGoodsStockById(goodsStockPO) > 0L;
    }

    @Override
    public void updateGoodsStockCache(GoodsStockPO goodsStockPO) {
        //缓存未命中，查询数据库
        GoodsStockPO stockPO = goodsStockDao.getGoodsStockById(goodsStockPO.getStockId());
        //更新缓存
        redisCacheCompoent.setCacheByKey(goodsStockPO.getRedisStockKey(), JSONObject.toJSONString(stockPO));
    }
}
