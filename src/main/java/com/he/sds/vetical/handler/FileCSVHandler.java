package com.he.sds.vetical.handler;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileCSVHandler implements FileTypeHandler{

    public static String separator=",";
    @Override
    public CSVFileData<List<String[]>> dealFileType(String fileName) {
        try (CSVReader reader=new CSVReader(new FileReader(fileName))){
            List<String[]> strings = reader.readAll();
            return new CSVFileData<>(strings);
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
