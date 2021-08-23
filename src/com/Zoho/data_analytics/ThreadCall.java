package com.Zoho.data_analytics;

import java.util.List;

public class ThreadCall extends Thread{
    private FileBufferReader fileBufferReader;
    private String fileName;
    private static int index;
    private List<String> lines;

    ThreadCall(FileBufferReader fileBufferReader,String fileName,int index){
        this.fileBufferReader = fileBufferReader;
        this.fileName = fileName;
        this.index = index;
    }

    @Override
    synchronized public void run(){
        try{
                ThreadQueue.fileStatus.set(index,"Runnable");
                lines = fileBufferReader.readFiles(fileName);
                fileBufferReader.convertLines(lines);

        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
              ThreadQueue.fileStatus.set(index,"Terminated");
              ThreadQueue.isCompleted = true;
        }
    }
}
