package com.company;

import com.company.services.BrowseCsvService;
import com.company.services.CSVReader;
import com.company.services.UIService;
import java.util.List;

public class Main {

    private static Integer PAGE_MAX_DISPLAY_LIMIT = 5;
    private static String SEPARATOR = ";";

    public static void main(String[] args) {
        UIService uiService = new UIService();
        CSVReader csvReader = new CSVReader();
        BrowseCsvService browseCsvService = new BrowseCsvService();

        uiService.initText();
        String filename = uiService.getFilename();
        List<String[]> rowData = csvReader.readFile(filename, SEPARATOR);


    }
}
