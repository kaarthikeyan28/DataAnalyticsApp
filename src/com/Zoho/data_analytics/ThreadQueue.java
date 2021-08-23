package com.Zoho.data_analytics;

import java.util.ArrayList;
import java.util.Scanner;

public class ThreadQueue extends Thread{
    private static int options;
    private static int threadID;
    private static int index=0;
    private ThreadCall threadCall;
    public static boolean isCompleted = true;
    public static ArrayList<String> fileStatus = new ArrayList<>();
    public static ArrayList<String> fileList = new ArrayList<>();
    public static ArrayList<Thread> threads = new ArrayList<>();


   synchronized public void addThreads(String fileName,FileBufferReader fileBufferReader){
        fileStatus.add("New");
        fileList.add(fileName);

        threadCall = new ThreadCall(fileBufferReader,fileName,index++);
        threads.add(threadCall);

        if(isCompleted==true){
            isCompleted=false;
            threadCall.run();
        }
       // threadCall.stop();
//        System.out.println(fileName+" "+isCompleted);
    }

    public static void delFiles(int index){

        if(threads.get(index).getState()==State.RUNNABLE){
            System.err.println("Sorry the File Started Execution !");
            return;
        }
        else if(threads.get(index).getState()==State.TERMINATED){
            System.err.println("Sorry the File has Completed Execution !");
            return;
        }
        else if(threads.get(index).getState()==State.NEW){
            System.out.println(threads.get(index)+" removed Successfully !");
            threads.remove(index);
            System.out.println("File removed Successfully !");
        }

    }



    public static void delThreads(int index){
       if((index <0  || index > fileList.size()-1)){
           System.err.println("Your Id doesn't exist !");
           return;
       }

       if(fileList.size()==0){
           System.err.println("Your Id doesn't exist !");
           return;
       }
        else if(fileStatus.get(index).equals("Runnable")){
            System.err.println("Sorry the File Started Execution !");
            return;
        }
        else if(fileStatus.get(index).equals("Terminated")){
            System.err.println("Sorry the File has already completed Execution !");
            return;
        }
        else if(fileStatus.get(index).equals("New")){
           System.out.println(fileList.get(index)+" removed Successfully !");
           threads.remove(index);
           fileStatus.remove(index);
           fileList.remove(index);
       }
   }

   public void fileView(){
       System.out.println(fileStatus);
   }

    public static void viewRunning(){
        Scanner sc = new Scanner(System.in);

        if(fileList.size()==0 || threads.size()==0){
            System.out.println("No files in Queue !");
            return;
        }
        System.out.println("Files in Queue :-");
        System.out.println("-------------------------------------------------------------------");

        System.out.println("ID               File Name                 Status");
        for(int i=0;i< threads.size();i++){
            System.out.println((i+1)+"                "+fileList.get(i)+"                "+fileStatus.get(i));
        }
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
        //delFiles(threadID-1);
    }
}
