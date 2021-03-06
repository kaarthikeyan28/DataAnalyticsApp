package com.Zoho.data_analytics.DB;

import com.Zoho.data_analytics.JDBC.JDBC;

import java.sql.*;

public class MySQL implements Database{
    private Connection conn;
    private String sql;

    public MySQL() {
        this.conn = JDBC.getConnection();
    }

    @Override
    public int createTable(String tablename, String[] columnNames) {

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(tablename);
            sb.append(" (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,");

            for (int i = 0; i < columnNames.length; i++) {
                sb.append(columnNames[i]);
                sb.append(" ");
                if (i == columnNames.length - 1) sb.append("VARCHAR(1000)");
                else sb.append("VARCHAR(1000),");
            }
            sb.append(");");

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sb.toString());


            int len = columnNames.length;

            String generateColumn = " (";

            for(int i=0;i<len;i++){
                if(i==len-1) break;
                generateColumn=generateColumn+columnNames[i]+",";
            }
            generateColumn=generateColumn+columnNames[len-1]+") ";


            sql = "INSERT INTO " + tablename + generateColumn + " VALUES(";

            String questionmark = "";

            for (int i = 0; i < len; i++) {
                if (i == len - 1) {
                    questionmark = questionmark + "?" + ");";
                    break;
                }
                questionmark = questionmark + "?" + ",";
            }
            sql = sql + questionmark;

        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    @Override
     public void insertValues(String[] data) {
        try {
            PreparedStatement ptst = conn.prepareStatement(sql);

                if (data.length != 0) {

                    for (int j = 0; j < data.length; j++) {
                        ptst.setString(j + 1, data[j]);
                    }
                    ptst.executeUpdate();
                }
        }
        catch(Exception e){
            e.printStackTrace();
           // System.err.println("Invalid Data !");
        }
    }
}
