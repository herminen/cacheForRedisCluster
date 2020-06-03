package com.lh.stock.lhstock.syncdata.request.impl;

import com.lh.stock.lhstock.po.GoodsStockPO;
import com.lh.stock.lhstock.service.IGoodsStockService;
import com.lh.stock.lhstock.syncdata.request.ISyncRequest;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 19:44
 */
public class ModifyGoodsStockRequest implements ISyncRequest {

    private GoodsStockPO goodsStockPO;

    private IGoodsStockService goodsStockService;

    public ModifyGoodsStockRequest(GoodsStockPO goodsStockPO, IGoodsStockService goodsStockService) {
        this.goodsStockPO = goodsStockPO;
        this.goodsStockService = goodsStockService;
    }

    @Override
    public String getReuestId() {
        return String.valueOf(goodsStockPO.getGoodsId());
    }

    @Override
    public void process() {
        //更新商品库存
        goodsStockService.updateGoodsStockById(goodsStockPO);
    }
}
