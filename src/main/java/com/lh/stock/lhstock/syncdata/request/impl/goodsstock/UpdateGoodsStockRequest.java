package com.lh.stock.lhstock.syncdata.request.impl.goodsstock;

import com.lh.stock.lhstock.po.GoodsStockPO;
import com.lh.stock.lhstock.service.IGoodsStockService;
import com.lh.stock.lhstock.syncdata.request.ISyncRequest;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 20:15
 */
public class UpdateGoodsStockRequest extends AbstractGoodsStockRequest implements ISyncRequest {


    public UpdateGoodsStockRequest(GoodsStockPO goodsStockPO, IGoodsStockService goodsStockService) {
        super(goodsStockPO, goodsStockService);
    }


    @Override
    public void process() {
        goodsStockService.updateGoodsStockCache(goodsStockPO);
    }
}