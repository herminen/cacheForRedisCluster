package com.lh.stock.lhstock.syncdata.request.impl.goodsstock;

import com.lh.stock.lhstock.po.GoodsStockPO;
import com.lh.stock.lhstock.service.IGoodsStockService;
import com.lh.stock.lhstock.syncdata.request.ISyncRequest;
import com.lh.stock.lhstock.syncdata.request.impl.goodsstock.AbstractGoodsStockRequest;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 19:44
 */
public class ModifyGoodsStockRequest extends AbstractGoodsStockRequest implements ISyncRequest {


    public ModifyGoodsStockRequest(GoodsStockPO goodsStockPO, IGoodsStockService goodsStockService) {
        super(goodsStockPO, goodsStockService);
    }

    @Override
    public void process() {
        //更新商品库存
        goodsStockService.updateGoodsStockById(goodsStockPO);
    }
}
