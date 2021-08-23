package com.Zoho.data_analytics;

import java.util.ArrayList;
import java.util.List;

public class JsonConsoleFileReader extends ConsoleFileReader{
    private Database database;

    JsonConsoleFileReader(Database database){
        this.database = database;
    }

    @Override
    public void convertLines(List<String> lines) {

        if(lines==null) return;

        String str="}";
        List<String> columnList = new ArrayList<>();

        for(int i=0;i<lines.size();i++){

                String[] stringArray = lines.get(i).split(":");
                String temp = stringArray[0];

                temp= temp.replaceAll("\\s", "");

                if(temp.equals("{") || temp.equals("[")) continue;
                temp = temp.replaceAll("[^a-zA-Z0-9}]", "");

                if(temp.equals("}") || temp.equals("]")) break;
                columnList.add(temp);
        }

        String[] columnNames = new String[columnList.size()];

        for(int i=0;i<columnNames.length;i++){
            columnNames[i] = columnList.get(i);
        }

        int status = database.createTable(getTableName(),columnNames);

        if(status==-1) return;

        List<String> valuesList = new ArrayList<>();

        StringBuffer stringBuffer = new StringBuffer();


        for(int i=0;i<lines.size();i++){
            lines.set(i,lines.get(i).replaceAll("\\s",""));
            lines.set(i, lines.get(i).replaceAll(",",""));
            lines.set(i, lines.get(i).replaceAll("\"",""));
        }

        String prev ="{";
        String next=null;

        for(int i=2;i<lines.size()-1;i++){
            String current = lines.get(i);

            if(current.equals("{") || current.equals("},") || current.equals("[") || current.equals("]") || current.equals("}")){
                if(current.equals("}")){
                    valuesList.add(stringBuffer.toString());
                    stringBuffer.setLength(0);
                }
                continue;
             }
            next = (current.split("\\:")[1]);
            if(i==lines.size()-1){
                stringBuffer.append(next);
                break;
            }
            stringBuffer.append(next);
            if(lines.get(i+1).equals("}")) continue;
            stringBuffer.append(",");
        }

        for(int i=0;i< valuesList.size();i++){

            String[] data = valuesList.get(i).split(",");

            database.insertValues(data);
        }
        //System.out.println(getTableName()+" Inserted !");
    }
}
