package com.company.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVReader {
    public String[] readFile(String filename, String separator) {
        String[] rawlines = null;
        Path filePath = Paths.get(".", "res", filename).normalize().toAbsolutePath();

        //        # TODO what was the best way to read csv ?
        //        try with resources closes the stream (since java 7)
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath, StandardCharsets.US_ASCII)) {
            rawlines = bufferedReader
                .lines()
                .map(line -> line.split(separator))
                .toArray(String[]::new);
        } catch (FileNotFoundException fileNotFoundEx) {
            //#TODO feedback print something ? Log something ?
        } catch (IOException ioEx) {
            //#TODO feedback
        }

        return rawlines;
    }



}
