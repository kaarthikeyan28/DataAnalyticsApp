package com.Zoho.data_analytics.File;
import com.Zoho.data_analytics.DB.Database;

import java.util.List;

public class CsvConsoleFileReader extends ConsoleFileReader {
    private Database database;

    public CsvConsoleFileReader(Database database){
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public void run(){

    }

    @Override
    public void convertLines(List<String> lines) {

        if(lines==null) return;

        String[] columnNames =  lines.get(0).split(",");

        for(int i=0; i<columnNames.length; i++) {
            columnNames[i] = columnNames[i].replaceAll("[^a-zA-Z0-9]", "_");
        }

        int status = database.createTable(getTableName(),columnNames);

        if(status==-1) return;

        for(int i=1;i<lines.size();i++){

            String data[] = lines.get(i).split(",");

            database.insertValues(data);
        }

        try {
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println(getTableName()+" Inserted !");
    }
}
