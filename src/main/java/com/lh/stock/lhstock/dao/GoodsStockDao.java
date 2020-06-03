package com.lh.stock.lhstock.dao;

import com.lh.stock.lhstock.po.GoodsStockPO;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 19:26
 */
public interface GoodsStockDao {

    Long updateGoodsStockById(GoodsStockPO goodsStockPO);

    GoodsStockPO getGoodsStockById(@Param("stockId") Long stockId);
}
