package com.Zoho.data_analytics;
import java.util.List;

public class CsvConsoleFileReader extends ConsoleFileReader{
    private Database database;

    CsvConsoleFileReader(Database database){
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
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
        //System.out.println(getTableName()+" Inserted !");
    }
}
