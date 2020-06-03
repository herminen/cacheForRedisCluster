package com.lh.stock.lhstock.syncdata;

import com.lh.stock.lhstock.syncdata.request.ISyncRequest;
import com.lh.stock.lhstock.syncdata.request.SyncRequestQueue;
import com.lh.stock.lhstock.syncdata.thread.SyncDataCallable;

import java.util.concurrent.*;

/**
 * @Author: liuhai
 * @Date: 2020/6/3 16:20
 */
public class SyncDataThreadExecutor {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 60,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
    private static SyncRequestQueue syncRequestQueue = SyncRequestQueue.getInstance(2);

    private SyncDataThreadExecutor(){

    }

    public static SyncDataThreadExecutor getInstance(){
        return SyncDataThreadExecutorSingltonHolder.syncDataThreadExecutor;
    }

    public static SyncDataThreadExecutor initSyncDataThreadExecutor(){
        SyncDataThreadExecutor syncDataThreadExecutor = SyncDataThreadExecutorSingltonHolder.syncDataThreadExecutor;
        for (int i = 0; i < 2; i++) {
            executor.submit(new SyncDataCallable(syncRequestQueue.getSyncRequestQueue(i)));
        }
        return syncDataThreadExecutor;
    }

    public void syncData(ISyncRequest syncRequest){
        syncRequestQueue.addSyncRequest(syncRequest);
    }

    private static final class SyncDataThreadExecutorSingltonHolder{
        private static SyncDataThreadExecutor syncDataThreadExecutor = new SyncDataThreadExecutor();
    }
}
