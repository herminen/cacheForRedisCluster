package com.lh.stock.lhstock.syncdata.request;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 15:40
 */
public interface ISyncRequest {

    /**
     * 请求id--可以是业务id
     * @return
     */
    String getReuestId();

    /**
     * 处理请求
     */
    void process();

    String toString();
}
