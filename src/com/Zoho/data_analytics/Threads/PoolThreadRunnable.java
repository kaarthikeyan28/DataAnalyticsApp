package com.Zoho.data_analytics.Threads;

import com.Zoho.data_analytics.Queue.BlockingQueue;
import com.Zoho.data_analytics.Queue.DisplayQueue;

public class PoolThreadRunnable implements Runnable {

    private Thread thread    = null;
    private BlockingQueue taskQueue = null;

    public PoolThreadRunnable(BlockingQueue queue){
        taskQueue = queue;
    }

    public void run(){
        this.thread = Thread.currentThread();
        while(true){
            try{
                Runnable runnable = (Runnable) taskQueue.dequeue();
                if(DisplayQueue.map.get(runnable).equals("New")) {
                    DisplayQueue.map.put(runnable,"Runnable");
                    runnable.run();
                    DisplayQueue.map.put(runnable,"Terminated");
                }
                else{
                   // System.out.println(runnable.toString());
                    taskQueue.removeElements(runnable);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}