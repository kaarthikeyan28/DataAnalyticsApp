package com.Zoho.data_analytics.Threads;

import com.Zoho.data_analytics.File.Factory;
import com.Zoho.data_analytics.File.FileBufferReader;
import com.Zoho.data_analytics.Queue.GenericQueue;
import java.util.List;

public class Import implements Runnable{
    private String extension;
    private String fileName;
    private GenericQueue<String> files;
    private FileBufferReader fileBufferReader;
    private Factory factory;

    public void setFiles(GenericQueue<String> files) {
        this.files = files;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void run(){

        try {
            factory = new Factory();
            fileBufferReader = factory.getFileExtension(extension);

            System.out.println(fileName+"  Started");
            List<String> lines = fileBufferReader.readFiles(fileName);
            fileBufferReader.convertLines(lines);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println(fileName+": inserted successfully");
        }
    }

}
