package com.exxeta.cleancode;

import com.exxeta.cleancode.exceptions.CsvFileReadErrorException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReader {

    private Logger logger = Logger.getAnonymousLogger();

    public String[] readDataset(String fileName) {
        Path filePath = Paths.get(fileName);
        String[] resultLines;
        try {
            List<String> rawlineList = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            return rawlineList.toArray(new String[rawlineList.size()]);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Problem reading Csv", new CsvFileReadErrorException("Something went wrong with reading the csv"));
            return null;
        }
    }
}
