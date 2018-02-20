package com.company.services;

import com.company.Main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class CSVReader {

    DataWriter writer = new DataWriter();

    public void readFile(String filename) {
        String[] rawlines = null;
        Path filePath = Paths.get(".", "res", filename).normalize().toAbsolutePath();

        //        # TODO what was the best way to read csv ?
        //        try with resources closes the stream (since java 7)   Java 8 way in implementieren
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath, StandardCharsets.US_ASCII)) {
            rawlines = bufferedReader
                .lines()
                .toArray(String[]::new);
        } catch (FileNotFoundException fileNotFoundEx) {
            //#TODO feedback print something ? Log something ?   throws exception ...
        } catch (IOException ioEx) {
            //#TODO feedback throws exception ...
        }

        writer.setHeadline(rawlines[0].split(Main.SEPARATOR));
        writer.setRawlines(Arrays.copyOfRange(rawlines, 1, rawlines.length));
    }



}
