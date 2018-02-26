package com.company;

import com.company.services.CSVReader;
import com.company.services.FilenameService;
import com.company.services.PagePrinter;

public class Main {
    public static Integer PAGE_ROW_LIMIT = 5;
    public static String SEPARATOR = ";";

    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        PagePrinter pagePrinter = new PagePrinter();
        FilenameService filenameService = new FilenameService();

        pagePrinter.printGreeting();

        // Usage of lambda expressions for better testing
        String filename = filenameService.getFilename(args);

        csvReader.readFile(filename);
        pagePrinter.printFirstPage();

        pagePrinter.executeUsersAction();
    }
}
