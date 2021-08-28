package com.Zoho.data_analytics.Queue;
import java.util.ArrayList;
import java.util.Iterator;

public class GenericQueue<T> {
    public ArrayList<T>  arr = new ArrayList<>();

    public T poll(){
        return arr.get(0);
    }

    public T get(int index){
        return arr.get(index);
    }

    public void deQueue(){
        if(!arr.isEmpty()) arr.remove(arr.size()-1);
        else{
            System.err.println("Queue is Empty !");
        }
    }

    public int queueSize(){
        return arr.size();
    }

    public void enQueue(T obj){
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
