package com.he.sds.vetical.handler;

import java.util.ArrayList;
import java.util.List;

public class CSVFileData<T> implements FileData<T>{

    T result;
    public CSVFileData(T result) {
        this.result = result;
    }

    public CSVFileData() {
    }

    @Override
    public T getData() {
        return result;
    }
}
