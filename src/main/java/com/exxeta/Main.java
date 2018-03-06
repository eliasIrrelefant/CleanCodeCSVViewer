package com.exxeta;

import com.exxeta.services.CSVReader;
import com.exxeta.services.FilenameService;
import com.exxeta.services.PageOutput;

public class Main {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        PageOutput pageOutput = new PageOutput();
        FilenameService filenameService = new FilenameService();

        pageOutput.printGreeting();

        // Usage of lambda expressions for better testing
        String filename = filenameService.getFilename(args);

        // ggf. File zurückgeben und im nächsten Schritt in den Store legen.
        csvReader.readFile(filename);

        // TODO In der Kritik wurde der zentrale Zustand bemängelt, wieso ist das nicht gut?
        // Im Flowchart ist es so angegeben. Sind zentrale Konfig-Dateien nicht erwünscht?

        // TODO Naming im Flowchart vs. Naming in der Implementierung. parseRecords wurde bemängelt, stand aber so in den Anforderungen



        pageOutput.printFirstPage();

        pageOutput.executeUsersAction();
    }
}
