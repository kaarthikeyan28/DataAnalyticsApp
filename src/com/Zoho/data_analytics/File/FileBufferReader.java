package com.Zoho.data_analytics.File;

import java.util.List;

public interface FileBufferReader {
    public List<String> readFiles(String filename);
    public void convertLines(List<String> lines);
}

