package com.he.sds;

import com.he.sds.vetical.handler.FileType;
import com.he.sds.vetical.handler.MineSectionHandler;

public class MineSectionTest {

    public static void main(String[] args) {
        new MineSectionHandler().dealData2Section("data.csv", FileType.CSV);
    }
}
