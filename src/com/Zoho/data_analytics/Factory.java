package com.Zoho.data_analytics;

public class Factory{
    public ConsoleFileReader getFileExtension(String extension){
        if(extension.equals("csv")){
            return new CsvConsoleFileReader(new MySQL());
        }
        else if(extension.equals("json")){
            return new JsonConsoleFileReader(new MySQL());
        }
        return null;
    }
}
