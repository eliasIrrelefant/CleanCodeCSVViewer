package com.company;

import com.company.services.BrowseCsvService;
import com.company.services.CSVReader;
import com.company.services.UIService;

public class Main {
    public static Integer PAGE_ROW_LIMIT = 5;
    public static String SEPARATOR = ";";

    // #todo test schreiben

    public static void main(String[] args) {
        UIService uiService = new UIService();
        CSVReader csvReader = new CSVReader();
        BrowseCsvService browseCsvService = new BrowseCsvService();

        uiService.printGreeting();
        // Args auslesen.

        String filename = null;

        // in eigene klasse auslagern()
        if (args.length <= 0 && args[0] == "") {
            filename = uiService.getFilename();
        } else {
            filename = args[0];
        }

        csvReader.readFile(filename);

        // Kommt in den PagePrinter, die Main entscheidet, auf welcher Seite wir starten
        browseCsvService.extractFirstPage();

        // --- Show First Page ---
        // String[] firstPage = browseCsvService.extractFirstPage();
        // Record[] firstPageRecords = RecordParser.parse(firstPage);
        //uiService.printRecords(firstPageRecords);

        // --- Show Last Page ---
        // String[] lastPage = browseCsvService.extractLastPage();
        // Record[] firstPageRecords = RecordParser.parse(lastPage);
        //uiService.printRecords(firstPageRecords);

        // --- Show Page x ---

        // #TODO hier kommt dann des java 8 if dings
        uiService.awaitInput();

    }
}
