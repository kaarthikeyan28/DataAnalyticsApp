package com.Zoho.data_analytics.GUI;

import com.Zoho.data_analytics.File.FileBufferReader;
import com.Zoho.data_analytics.Queue.GenericQueue;
import com.Zoho.data_analytics.Threads.ThreadCall;
import com.Zoho.data_analytics.Threads.ThreadQueue;
import java.util.Scanner;

public class Import extends Thread {

    private static int index=0;
    private ThreadCall threadCall;
    private String extension;
    private String fileName;
    private GenericQueue<Thread> genericQueue;
    private ThreadQueue threadQueue;
    private FileBufferReader fileBufferReader;
    private Factory factory;

    public GenericQueue<Thread> getGenericQueue() {
        return genericQueue;
    }

    public void setGenericQueue(GenericQueue<Thread> genericQueue) {
        this.genericQueue = genericQueue;
    }
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public void setThreadQueue(ThreadQueue threadQueue) {
        this.threadQueue = threadQueue;
    }


    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);

        String dot=".";

        if(!(fileName.contains(dot))){
            System.err.println("Extension Invalid !");
            return;
        }

        extension = (fileName.split("\\.")[1]);

        if(!(extension.equals("csv") || extension.equals("json"))){
            System.err.println("Only Csv and Json are acceptable !");
            return;
        }

        factory = new Factory();
        fileBufferReader = factory.getFileExtension(extension);

        threadCall = new ThreadCall(fileBufferReader,fileName,index++);
        threadCall.setName(fileName);
        genericQueue.addFiles(threadCall);
        threadCall.start();


        //threadQueue.addThreads(fileName,fileBufferReader);
    }
}
