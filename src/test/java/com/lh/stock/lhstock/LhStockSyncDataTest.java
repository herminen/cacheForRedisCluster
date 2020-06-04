package com.lh.stock.lhstock;

import com.lh.stock.lhstock.component.ICacheComponent;
import com.lh.stock.lhstock.po.GoodsStockPO;
import com.lh.stock.lhstock.service.IGoodsStockService;
import com.lh.stock.lhstock.syncdata.SyncDataThreadExecutor;
import com.lh.stock.lhstock.syncdata.request.impl.goodsstock.ModifyGoodsStockRequest;
import com.lh.stock.lhstock.syncdata.request.impl.goodsstock.UpdateGoodsStockRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 20:43
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LhStockSyncDataTest {

    @Autowired
    IGoodsStockService goodsStockService;

    @Autowired
    SyncDataThreadExecutor syncDataThreadExecutor;

    @Autowired
    @Qualifier("jedisCacheComponent")
    ICacheComponent redisCacheService;

    @Test
    public void testGoodsStockConsensus() throws InterruptedException {
        GoodsStockPO stockPO = new GoodsStockPO();
        stockPO.setStockId(1L);
        stockPO.setGoodsId(1L);
        stockPO.setGoodsStock(500L);

//        ModifyGoodsStockRequest modifyGoodsStockRequest = new ModifyGoodsStockRequest(stockPO,goodsStockService);

        UpdateGoodsStockRequest updateGoodsStockRequest = new UpdateGoodsStockRequest(stockPO, goodsStockService);
        syncDataThreadExecutor.syncData(updateGoodsStockRequest);


        Thread.sleep(2000);
        System.out.println(redisCacheService.getCacheByKey(stockPO.getRedisStockKey()));



    }
}
