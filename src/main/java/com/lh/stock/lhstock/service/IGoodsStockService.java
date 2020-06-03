package com.lh.stock.lhstock.service;

import com.lh.stock.lhstock.dao.GoodsStockDao;
import com.lh.stock.lhstock.po.GoodsStockPO;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 19:32
 */
public interface IGoodsStockService {

    /**
     * 更新商品库存--符合cache aside pattern
     * @param goodsStockPO
     * @return
     */
    boolean updateGoodsStockById(GoodsStockPO goodsStockPO);

    /**
     * 查询商品库存信息
     * @param goodsStockPO
     * @return
     */
    GoodsStockPO fetchGoodsStockById(GoodsStockPO goodsStockPO);
}
