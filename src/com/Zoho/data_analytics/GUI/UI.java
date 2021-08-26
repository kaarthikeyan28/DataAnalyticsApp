package com.Zoho.data_analytics.GUI;
import com.Zoho.data_analytics.Queue.GenericQueue;
import com.Zoho.data_analytics.Threads.ThreadQueue;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI{
    private String name;
    private int options;
    private int poolSize;
    private String fileName;
    private GenericQueue<Thread> genericQueue = new GenericQueue();
    private Import importObject = new Import();
    public ThreadQueue threadQueue = new ThreadQueue();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void Home(){
        Scanner sc = new Scanner(System.in);

        //System.out.println("How can I call you ?");

        name = "Kaarthi";

        System.out.println("Hello "+name+" !");

        System.out.println("Enter Pool Size");
        poolSize = sc.nextInt();
        genericQueue.setTotalThreads(poolSize);

        try {
            do {
//                System.out.println("Enter Pool Size :");
//                poolSize = sc.nextInt();
                System.out.println("Choose your Options :");
                System.out.println("1.Import Files\n2.View Ready Queue\n3.Exit");
                options = sc.nextInt();
                sc.nextLine();
                if (options == 3) break;
                switch (options) {

                    case 1: {
                        System.out.println("Please enter your Filename ");
                        fileName = sc.nextLine();
                        //importObject.setPoolSize(poolSize);
                        importObject.setFileName(fileName);
                        importObject.setGenericQueue(genericQueue);
                        importObject.setThreadQueue(threadQueue);
                        Thread t1 = new Thread(importObject);
                        t1.start();
                        break;
                    }
                    case 2: {
                        genericQueue.showFiles();
                        break;
                    }
                    default: {
                        System.err.println("Your options doesn't exist !");
                        break;
                    }

                }
            } while (true);

            System.out.println("Thank You !");
        }
        catch (InputMismatchException inputMismatchException){
            System.err.println("Please Select Valid option !");
        }
    }
}
