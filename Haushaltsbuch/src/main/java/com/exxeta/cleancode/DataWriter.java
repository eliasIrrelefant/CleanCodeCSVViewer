package com.exxeta.cleancode;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DataWriter {

    public void writeDataset(String[] dataset, String filename) {
        for (dataset
        Files.write(Paths.get(filename),  dataset);
    }

}
