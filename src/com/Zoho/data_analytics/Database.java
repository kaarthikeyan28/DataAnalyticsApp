package com.Zoho.data_analytics;

public interface Database{
    public int createTable(String tablename , String[] columnNames);
    public void insertValues(String[] data);
}