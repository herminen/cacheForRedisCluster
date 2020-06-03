package com.lh.stock.lhstock.syncdata.request.impl.goodsstock;

import com.lh.stock.lhstock.po.GoodsStockPO;
import com.lh.stock.lhstock.service.IGoodsStockService;
import com.lh.stock.lhstock.syncdata.request.ISyncRequest;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 20:16
 */
public abstract class AbstractGoodsStockRequest implements ISyncRequest {

    protected GoodsStockPO goodsStockPO;

    protected IGoodsStockService goodsStockService;

    public AbstractGoodsStockRequest(GoodsStockPO goodsStockPO, IGoodsStockService goodsStockService) {
        this.goodsStockPO = goodsStockPO;
        this.goodsStockService = goodsStockService;
    }

    @Override
    public String getReuestId() {
        return String.valueOf(goodsStockPO.getGoodsId());
    }
}
