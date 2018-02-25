package com.company;

import com.company.services.CSVReader;
import com.company.services.PagePrinter;

public class Main {
    public static Integer PAGE_ROW_LIMIT = 5;
    public static String SEPARATOR = ";";

    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        PagePrinter pagePrinter = new PagePrinter();

        pagePrinter.printGreeting();
        String filename = pagePrinter.getFilename(args);

        csvReader.readFile(filename);
        pagePrinter.printFirstPage();



        pagePrinter.executeUsersAction();


        // Kommt in den PagePrinter, die Main entscheidet, auf welcher Seite wir starten

        // #TODO hier kommt dann des java 8 if dings
        //        uiService.awaitInput();
    }
}
