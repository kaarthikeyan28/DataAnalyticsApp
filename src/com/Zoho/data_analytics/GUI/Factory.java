package com.Zoho.data_analytics.GUI;

import com.Zoho.data_analytics.DB.MySQL;
import com.Zoho.data_analytics.File.ConsoleFileReader;
import com.Zoho.data_analytics.File.CsvConsoleFileReader;
import com.Zoho.data_analytics.File.JsonConsoleFileReader;

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
