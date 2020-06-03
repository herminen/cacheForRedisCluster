package com.lh.stock.lhstock.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static com.lh.stock.lhstock.constant.RedisKeyConstants.GOODS_STOCK_REDIS_KEY;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 19:27
 */
@Getter
@Setter
@ToString
public class GoodsStockPO {

    /**
     * 主键
     */
    private Long stockId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品库存
     */
    private Long goodsStock;

    public String getRedisStockKey(){
        return GOODS_STOCK_REDIS_KEY + goodsId;
    }
}
