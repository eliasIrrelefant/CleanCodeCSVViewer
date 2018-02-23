package com.company.services;

import com.company.Main;
import com.company.models.Record;
import com.company.store.ProcessingData;

public class PagePrinter {
    BrowseCsvService browseCsvService = new BrowseCsvService();
    UIService uiService = new UIService();

    public void printGreeting() {
        uiService.printGreeting();
    }

    public void printFirstPage() {
        String[] extractedPage = browseCsvService.extractPage(0);
        Record[] records = browseCsvService.parseRecords(extractedPage);

        uiService.printRecords(records);
    }

    public void printLastPage() {
        String[] extractedPage = browseCsvService.extractPage(ProcessingData.RAWLINES.length / Main.PAGE_ROW_LIMIT);
        Record[] records = browseCsvService.parseRecords(extractedPage);

        uiService.printRecords(records);
    }

    // --- Show First Page ---
    // String[] firstPage = browseCsvService.extractFirstPage();
    // Record[] firstPageRecords = RecordParser.parse(firstPage);
    //uiService.printRecords(firstPageRecords);

    // --- Show Last Page ---
    // String[] lastPage = browseCsvService.extractLastPage();
    // Record[] firstPageRecords = RecordParser.parse(lastPage);
    //uiService.printRecords(firstPageRecords);

    public String getFilename(String[] args) {
        if (args.length <= 0 && args[0] == "") {
            return uiService.getFilename();
        } else {
            return args[0];
        }

    }


}
