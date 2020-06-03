package com.lh.stock.lhstock.syncdata.request;

import com.google.common.collect.Lists;

import java.util.Collections;
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

    public void addSyncRequest(ISyncRequest syncRequest){
        int queueNo = hashQueueNo(syncRequest);
        queueList.get(queueNo).add(syncRequest);
    }

    public ArrayBlockingQueue<ISyncRequest> getSyncRequestQueue(int pos){
        if(pos >= queueList.size() || pos < 0){
            return EMPTY_QUEUE;
        }
        return queueList.get(pos);
    }

    private int hashQueueNo(ISyncRequest syncRequest) {
        return syncRequest.getReuestId().hashCode() % queueList.size();
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
