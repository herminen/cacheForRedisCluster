package com.lh.stock.lhstock.syncdata.thread;

import com.lh.stock.lhstock.syncdata.request.ISyncRequest;
import com.lh.stock.lhstock.syncdata.request.SyncRequestQueue;
import com.lh.stock.lhstock.syncdata.response.ISyncResponse;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 16:05
 */
public class SyncDataCallable implements Callable<ISyncResponse> {

    private ArrayBlockingQueue<ISyncRequest> syncRequestQueue;

    private volatile boolean shutdown = false;

    public SyncDataCallable(ArrayBlockingQueue<ISyncRequest> syncRequestQueue) {
        this.syncRequestQueue = syncRequestQueue;
    }

    @Override
    public ISyncResponse call() throws Exception {
        while(!shutdown){
            ISyncRequest poll = syncRequestQueue.poll(100, TimeUnit.MILLISECONDS);
            if(null != poll){
                poll.process();
            }
        }
        return null;
    }

    public void shutdownThread(){
        this.shutdown = true;
    }
}
