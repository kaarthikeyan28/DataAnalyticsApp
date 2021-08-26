package com.Zoho.data_analytics.Queue;
import java.util.ArrayList;
import java.util.Iterator;

public class GenericQueue<T> {
    private int totalThreads;

    public int getTotalThreads() {
        return totalThreads;
    }

    public void setTotalThreads(int totalThreads) {
        this.totalThreads = totalThreads;
    }

    public ArrayList<T>  arr = new ArrayList<>(totalThreads);

    public T poll(){
        return arr.get(0);
    }

    public int size(){
        return arr.size();
    }

    public void addFiles(T obj){
        arr.add(obj);
    }

    public void delQueue(T obj){
        arr.remove(obj);
    }

    public void showFiles(){
        Iterator<T> iterator = arr.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
