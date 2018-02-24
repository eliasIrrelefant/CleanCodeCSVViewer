package com.company.services;

import com.company.Main;
import com.company.exceptions.CsvFileReadErrorException;
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
    DataStore writer = new DataStore();
    Logger logger = Logger.getAnonymousLogger();

    public void readFile(String filename) {

        String[] rawlines = null;
        Path filePath = Paths.get(".", "res", filename).normalize().toAbsolutePath();

        try {
            List<String> rawlineList = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            rawlines = rawlineList.toArray(new String[rawlineList.size()]);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Problem reading Csv", new CsvFileReadErrorException("Something went wrong with reading the csv"));
        }

        writer.setHeadline(rawlines[0].split(Main.SEPARATOR));
        Integer maxPages = (rawlines.length - 1) / Main.PAGE_ROW_LIMIT;
        writer.setMaxPages(maxPages);
        writer.setRawlines(Arrays.copyOfRange(rawlines, 1, rawlines.length));
    }



}
