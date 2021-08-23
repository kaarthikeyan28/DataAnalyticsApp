package com.Zoho.data_analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

abstract public class ConsoleFileReader implements FileBufferReader{
    private String fileName;
    private String tableName;
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFilename() {
        return fileName;
    }
    public void setFilename(String filename) {
        this.fileName = filename;
    }

    public List<String> readFiles(String fileName){
        try{
            tableName = (fileName.split("\\.")[0]);

            String path = "C:\\Users\\hp\\Desktop\\ZohoProject" + "\\" + fileName;

            BufferedReader reader = new BufferedReader(new FileReader(path));
            List<String> lines = new ArrayList<>();
            String line = null;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        }
        catch (FileNotFoundException exe){
            System.err.println("Your file doesn't exist :(");
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    abstract public void convertLines(List<String> lines);

}
