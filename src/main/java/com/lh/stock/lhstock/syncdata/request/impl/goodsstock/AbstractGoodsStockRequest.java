package com.lh.stock.lhstock.syncdata.request.impl.goodsstock;

import com.lh.stock.lhstock.po.GoodsStockPO;
import com.lh.stock.lhstock.service.IGoodsStockService;
import com.lh.stock.lhstock.syncdata.request.ISyncRequest;

import java.util.Objects;

import static com.lh.stock.lhstock.constant.SeparatorConstants.SEP_COMBINE_KEY;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 20:16
 */
public abstract class AbstractGoodsStockRequest implements ISyncRequest {

    protected GoodsStockPO goodsStockPO;

    protected IGoodsStockService goodsStockService;

    protected String type;

    public AbstractGoodsStockRequest(GoodsStockPO goodsStockPO, IGoodsStockService goodsStockService,String type) {
        this.goodsStockPO = goodsStockPO;
        this.goodsStockService = goodsStockService;
        this.type = type;
    }

    @Override
    public String getReuestId() {
        return String.valueOf(goodsStockPO.getGoodsId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractGoodsStockRequest that = (AbstractGoodsStockRequest) o;
        return Objects.equals(type + SEP_COMBINE_KEY + getReuestId(), that.type + SEP_COMBINE_KEY + getReuestId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(type + SEP_COMBINE_KEY + getReuestId());
    }
}
