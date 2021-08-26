package com.Zoho.data_analytics.Queue;

import java.util.Iterator;

//public class QueueClass<T> {
//    T obj;
//
//    QueueClass(T obj){
//        this.obj = obj;
//    }
//
//    public T getObj(){
//        return this.obj;
//    }
//
//}

public class QueueClass{
    static int front=0;
    static int rear=0;
    static int[] queue;

    QueueClass(int total){
        this.queue = new int[total];
    }

    public static void addElements(int data){
        queue[rear++] = data;
    }

    public static void delElements(){

        front++;
//        Iterator iterator = iterator;
//        while (iterator.hasNext()){
//            if(data==iterator.next()){
//              // remove  queue[i];
//            }
//        }

    }

    public static void viewQueue(){

        for(int i=front;i<rear;i++){
            System.out.print(queue[i]+" ");
        }

    }

    public static void main(String[] args){

        new QueueClass(6);
        int arr[] = {5,64,46,2,5,1};
        for(int i=0;i<arr.length;i++){

            addElements(arr[i]);
        }
        delElements();
        viewQueue();
        System.out.println();
        delElements();
        viewQueue();
    }
}