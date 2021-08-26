package com.Zoho.data_analytics.Threads;

import com.Zoho.data_analytics.File.FileBufferReader;

import java.util.List;

public class ThreadCall extends Thread{
    private FileBufferReader fileBufferReader;
    private String fileName;
    private static int index;
    private List<String> lines;

    public ThreadCall(FileBufferReader fileBufferReader, String fileName, int index){
        this.fileBufferReader = fileBufferReader;
        this.fileName = fileName;
        this.index = index;
    }

    @Override
     public void run(){
        try{
                //ThreadQueue.fileStatus.set(index,"Runnable");
                lines = fileBufferReader.readFiles(fileName);
                fileBufferReader.convertLines(lines);

                System.out.println(fileName+" Inserted Sucessfully !");

        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
//              ThreadQueue.fileStatus.set(index,"Terminated");
//              ThreadQueue.isCompleted = true;
        }
    }
}
