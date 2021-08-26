package com.Zoho.data_analytics.DB;

public interface Database{
    public int createTable(String tablename , String[] columnNames);
    public void insertValues(String[] data);
}