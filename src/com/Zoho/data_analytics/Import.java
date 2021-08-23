package com.Zoho.data_analytics;

public class Import extends Thread {
    private String extension;
    private String fileName;
    private ThreadQueue threadQueue;
    private FileBufferReader fileBufferReader;
    private Factory factory;

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
        threadQueue.addThreads(fileName,fileBufferReader);
    }
}
