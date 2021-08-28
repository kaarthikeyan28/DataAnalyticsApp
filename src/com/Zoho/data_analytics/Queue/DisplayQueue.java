package com.Zoho.data_analytics.Queue;

import com.Zoho.data_analytics.GUI.UI;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class DisplayQueue{
    private static int options;
    private static int threadID;
    public static Map<Runnable,String> map = new LinkedHashMap<>();
    public static GenericQueue<String> files = new GenericQueue<>();

    public static void showFiles(){
        Scanner sc = new Scanner(System.in);

        int index=0;

        if(DisplayQueue.files.arr.size()==0){
            System.err.println("Queue is Empty !");
            return;
        }
        System.out.println("-------------------------------------------------------------------");

        System.out.println("Id    FileName       Status");
        for(Map.Entry<Runnable,String> entry : map.entrySet()){
            if(index<files.queueSize()) System.out.println((index+1)+"   "+files.get(index)+"     "+entry.getValue());
            index++;
        }

        //System.out.println("MAP:"+map);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Select One");
        System.out.println("To Stop the process -->  1");
        System.out.println("To Exit --> -1");

        options = sc.nextInt();

        if(options==-1){
            return;
        }

        System.out.println("Please enter Thread ID :");
        threadID = sc.nextInt();

        delThreads(threadID-1);

    }
    public static void delThreads(int index){

        if(index < 0 || index >= files.queueSize()){
            System.err.println("File doesn't exist !");
            return;
        }

        Runnable key = UI.importArrayList.get(index);
        String status = DisplayQueue.map.get(key);

        if(index < 0){
           System.err.println("File doesn't exist !");
           return;
       }
        else if(status.equals("Runnable")){
            System.err.println("Sorry the File has already Started !");
            return;
        }

        else if(status.equals("Terminated")){
            System.err.println("Sorry the File has already Terminated!");
            return;
        }
        else if(status.equals("New")){
           System.out.println(files.arr.get(index)+" removed Successfully !");

           DisplayQueue.files.arr.remove(index);
           DisplayQueue.map.remove(key);
           //DisplayQueue.map.put(key,"Removed");
            UI.importArrayList.remove(index);
       }
    }

}
