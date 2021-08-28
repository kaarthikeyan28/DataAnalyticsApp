package com.Zoho.data_analytics.Threads;
import com.Zoho.data_analytics.Queue.BlockingQueue;
import com.Zoho.data_analytics.Queue.DisplayQueue;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThreadRunnable> runnables = new ArrayList<>();

    public ThreadPool(int noOfThreads){
        taskQueue = new BlockingQueue(noOfThreads);

        for(int i=0; i<noOfThreads; i++){
            runnables.add(new PoolThreadRunnable(taskQueue));
        }

        for(PoolThreadRunnable runnable : runnables){
            new Thread(runnable).start();
        }
    }

    public synchronized void execute(Runnable task) throws Exception{
        DisplayQueue.map.put(task,"New");
        this.taskQueue.enqueue(task);
    }

}