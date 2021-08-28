package com.Zoho.data_analytics.Queue;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue{
    private List queue = new LinkedList();
    private int  limit = 0;

    public void displayQueue(){
        for(int i=0; i<queue.size(); i++){
            System.out.println(queue.get(i));
        }
    }

    public BlockingQueue(int limit){
        this.limit = limit;
    }

    public synchronized void enqueue(Object item)
            throws InterruptedException  {
        while(this.queue.size() == this.limit) {
            wait();
        }

        this.queue.add(item);

        if(this.queue.size() == 1) {
            notifyAll();
        }
    }

    public void removeElements(Object index){
        queue.remove(index);
    }

    public synchronized Object dequeue() throws InterruptedException{
        while(this.queue.size() == 0){
            wait();
        }
        if(this.queue.size() == this.limit){
            notifyAll();
        }
        return this.queue.remove(0);
    }

    public int getSize(){
        return this.queue.size();
    }
}
