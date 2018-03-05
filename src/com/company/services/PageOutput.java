package com.company.services;

import com.company.models.Record;

public class PageOutput {
    private BrowseCsvService browseCsvService = new BrowseCsvService();
    private UIService uiService = new UIService();
    private DataStore dataStore = new DataStore();
    private CSVParser parser = new CSVParser();

    public void printGreeting() {
        uiService.printGreeting();
    }

    public void printFirstPage() {
        Integer pageNumber = 0;
        printPage(pageNumber);
    }

    public void printLastPage() {
        Integer pageNumber = dataStore.getMaxPages();
        printPage(pageNumber);
    }

    public void printNextPage() {
        Integer pageNumber = dataStore.getPageNr() + 1;
        printPage(pageNumber);
    }

    public void printPreviousPage() {
        Integer pageNumber = dataStore.getPageNr() - 1;
        printPage(pageNumber);
    }

    private void printPage(Integer pageNumber) {
        pageNumber = browseCsvService.ensurePageIsInTheBound(pageNumber);
        String[] extractedPage = browseCsvService.extractPage(pageNumber);
        parseRawlinesAndPrintRecords(extractedPage);
        dataStore.setPageNr(pageNumber);
    }

    private void parseRawlinesAndPrintRecords(String[] extractedPage) {
        Record[] records = parser.parseRawlines(extractedPage);
        uiService.printRecords(records);
    }

    // TODO Nachdem PageOutput die nächste UserAction abfragen.
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
