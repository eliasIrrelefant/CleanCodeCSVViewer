package com.exxeta.services;

import com.exxeta.exceptions.CsvFileReadErrorException;
import com.exxeta.store.ApplicationParameters;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVReader {
    private DataStore dataStore = new DataStore();
    private Logger logger = Logger.getAnonymousLogger();

    public void readFile(String filename) {

        String[] rawlines = null;
        Path filePath = Paths.get(filename);

        System.out.println(filePath.getFileSystem().getRootDirectories());

        try {
            List<String> rawlineList = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            rawlines = rawlineList.toArray(new String[rawlineList.size()]);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Problem reading Csv", new CsvFileReadErrorException("Something went wrong with reading the csv"));
        }

        dataStore.setHeadline(rawlines[0].split(ApplicationParameters.SEPARATOR));
        Integer maxPages = (rawlines.length - 1) / ApplicationParameters.PAGE_ROW_LIMIT;
        dataStore.setMaxPages(maxPages);
        dataStore.setRawlines(Arrays.copyOfRange(rawlines, 1, rawlines.length));
    }
}
