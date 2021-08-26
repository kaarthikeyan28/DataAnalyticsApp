package com.Zoho.data_analytics.Queue;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;

public class FileQueue<T> {
    ArrayList<T> arr = new ArrayList<>();

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

class main{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        FileQueue<String> k = new FileQueue<String>();
        int options=1;
        do {
            System.out.println("Enter your file name :");
            String s = sc.next();
            k.addFiles(s);
            System.out.println("do you want to add files ? ");
            options = sc.nextInt();
        }while(options!=-1);
        k.showFiles();
        k.delQueue("books");
        k.showFiles();
    }
}
