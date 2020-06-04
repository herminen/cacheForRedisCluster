package com.lh.stock.lhstock.syncdata.request;

import com.google.common.collect.Lists;
import com.lh.stock.lhstock.syncdata.request.impl.goodsstock.RefreshGoodsStockRequest;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 15:42
 */
public class SyncRequestQueue {

    private List<ArrayBlockingQueue<ISyncRequest>> queueList;
    private static ArrayBlockingQueue<ISyncRequest> EMPTY_QUEUE = new ArrayBlockingQueue<ISyncRequest>(1);


    private SyncRequestQueue(int queueSize){
        queueList = Lists.newArrayListWithExpectedSize(queueSize);
        for (int i = 0; i < queueSize; i++) {
            queueList.add(new ArrayBlockingQueue<ISyncRequest>(100));
        }
    }

    /**
     * 请求入队列
     * @param syncRequest
     */
    public void addSyncRequest(ISyncRequest syncRequest){
        int queueNo = hashQueueNo(syncRequest);
        //防止更新请求重复
        if(syncRequest instanceof RefreshGoodsStockRequest && queueList.get(queueNo).contains(syncRequest)){
            return;
        }
        queueList.get(queueNo).add(syncRequest);
    }

    /**
     * hash取模余，路由到请求队列--相同的key进同一个队列,对相同数据的修改、查询请求串行化
     * @param syncRequest
     * @return
     */
    private int hashQueueNo(ISyncRequest syncRequest) {
        return syncRequest.getReuestId().hashCode() % queueList.size();
    }

    public ArrayBlockingQueue<ISyncRequest> getSyncRequestQueue(int pos){
        if(pos >= queueList.size() || pos < 0){
            return EMPTY_QUEUE;
        }
        return queueList.get(pos);
    }

    public static SyncRequestQueue getInstance(int queueSize){
        return SyncRequestQueueSingltonHolder.initSyncRequestQueue(queueSize);
    }

    private static final class SyncRequestQueueSingltonHolder{

        private static SyncRequestQueue syncRequestQueue;

        public static final SyncRequestQueue initSyncRequestQueue(int queueSize){
             syncRequestQueue = new SyncRequestQueue(queueSize);
            return syncRequestQueue;
        }
    }
}
