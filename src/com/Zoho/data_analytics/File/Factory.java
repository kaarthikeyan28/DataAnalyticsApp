package com.Zoho.data_analytics.File;

import com.Zoho.data_analytics.DB.MySQL;

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
