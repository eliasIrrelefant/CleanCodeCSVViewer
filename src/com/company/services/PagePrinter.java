package com.company.services;

import com.company.models.Record;

public class PagePrinter {
    BrowseCsvService browseCsvService = new BrowseCsvService();
    UIService uiService = new UIService();
    DataStore dataStore = new DataStore();

    public void printGreeting() {
        uiService.printGreeting();

    }

    public void printFirstPage() {
        String[] extractedPage = browseCsvService.extractPage(0);
        parseToAndPrintRecords(extractedPage);
        dataStore.setPageNr(0);
    }

    public void printLastPage() {
        Integer resultPage = dataStore.getMaxPages() ;
        String[] extractedPage = browseCsvService.extractPage(resultPage);
        parseToAndPrintRecords(extractedPage);
        dataStore.setPageNr(resultPage);
    }

    public void printNextPage() {
        Integer resultPage = dataStore.getPageNr() + 1;
        resultPage = browseCsvService.ensurePageIsInTheBound(resultPage);
        String[] extractedPage = browseCsvService.extractPage(resultPage);
        parseToAndPrintRecords(extractedPage);
        dataStore.setPageNr(resultPage);
    }

    public void printPreviousPage() {
        Integer resultPage = dataStore.getPageNr() - 1;
        resultPage = browseCsvService.ensurePageIsInTheBound(resultPage);
        String[] extractedPage = browseCsvService.extractPage(resultPage);
        parseToAndPrintRecords(extractedPage);
        dataStore.setPageNr(resultPage);
    }

    private void parseToAndPrintRecords(String[] extractedPage) {
        Record[] records = browseCsvService.parseRecords(extractedPage);
        uiService.printRecords(records);
    }

    public String getFilename(String[] args) {
        if (args.length <= 0 && args[0].isEmpty()) {
            return uiService.getFilename();
        } else {
            return args[0];
        }
    }

    public void executeUsersAction() {
        Character input = uiService.awaitInput();

        if (input.equals('N')) {
            printNextPage();
        } else if (input.equals('P')) {
            printPreviousPage();
        } else if (input.equals('F')) {
            printFirstPage();
        } else if (input.equals('L')) {
            printLastPage();
        } else if (input.equals('E')) {
            System.exit(0);
        }

        executeUsersAction();
    }


    // Java 8 way ?
    interface BrowsingAction {
        void executeBrowsingAction();
    }

}
