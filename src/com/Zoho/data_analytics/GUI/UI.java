package com.Zoho.data_analytics.GUI;
import com.Zoho.data_analytics.Queue.DisplayQueue;
import com.Zoho.data_analytics.Queue.GenericQueue;
import com.Zoho.data_analytics.Threads.Import;
import com.Zoho.data_analytics.Threads.ThreadPool;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI{
    private String name;
    private int options;
    private int poolSize;
    private String fileName;
    private ThreadPool threadPool ;
    private GenericQueue<String> fileQueue;
    public static ArrayList<Import> importArrayList;

    UI(){
        fileQueue = new GenericQueue();
        importArrayList = new ArrayList<>();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void Home(){
        Scanner sc = new Scanner(System.in);

        name = "Kaarthi";
        System.out.println("Hello "+name+" !");
        System.out.println("Enter ThreadPool Size");
        poolSize = sc.nextInt();

        threadPool = new ThreadPool(poolSize);

        try {
            do {
                System.out.println("Choose your Options :");
                System.out.println("1.Import Files\n2.View Queue\n3.Exit");
                options = sc.nextInt();
                sc.nextLine();
                if (options == 3) break;
                switch (options) {

                    case 1: {
                        System.out.println("Please enter your Filename ");
                        fileName = sc.nextLine();

                        String dot = ".";

                        if (!(fileName.contains(dot))) {
                            System.err.println("Extension Invalid !");
                            break;
                        }

                        String extension = (fileName.split("\\.")[1]);

                        if (!(extension.equals("csv") || extension.equals("json"))) {
                            System.err.println("Only Csv and Json are acceptable !");
                            break;
                        }
                        DisplayQueue.files.arr.add(fileName);

                        Import importObject = new Import();
                        importArrayList.add(importObject);
                        importObject.setFiles(fileQueue);
                        importObject.setFileName(fileName);
                        importObject.setExtension(extension);

                        threadPool.execute(importObject);
                        break;
                    }
                    case 2: {
                        fileQueue.showFiles();
                        DisplayQueue.showFiles();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
