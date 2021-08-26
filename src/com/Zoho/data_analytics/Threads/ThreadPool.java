package com.Zoho.data_analytics.Threads;
import com.Zoho.data_analytics.Queue.GenericQueue;

public class ThreadPool<T>{
    int totalThreads;
    int index=-1;
    T obj;
    T[] array;

    public ThreadPool(int totalThreads)
    {
        this.totalThreads = totalThreads;
        array = (T[]) new Object[totalThreads];
    }

    public int getSize(){
        return index;
    }

    public void addFiles(T obj){
        array[++index] = obj;
    }

    public void delFiles(T obj){

    }
}
