package com.exxeta.services;

import com.exxeta.store.ApplicationParameters;
import java.util.Arrays;

public class BrowseCsvService {
    DataStore dataStore = new DataStore();

    String[] extractPage(Integer page) {
        Integer firstLine = page * ApplicationParameters.PAGE_ROW_LIMIT;
        Integer lastLine = firstLine + ApplicationParameters.PAGE_ROW_LIMIT;

        return Arrays.copyOfRange(dataStore.getRawlines(), firstLine, lastLine);
    }

    String[] extractPreviousPage(Integer page) {
        Integer firstLine = (page -1) * ApplicationParameters.PAGE_ROW_LIMIT;
        Integer lastLine = firstLine + ApplicationParameters.PAGE_ROW_LIMIT;

        return Arrays.copyOfRange(dataStore.getRawlines(), firstLine, lastLine);
    }

    String[] extractNextPage(Integer page) {
        Integer firstLine = (page +1) * ApplicationParameters.PAGE_ROW_LIMIT;
        Integer lastLine = firstLine + ApplicationParameters.PAGE_ROW_LIMIT;

        return Arrays.copyOfRange(dataStore.getRawlines(), firstLine, lastLine);
    }



    public Integer ensurePageIsInTheBound(Integer page) {
        if (page < 0) {
            page = 0;
        }

        if (page > dataStore.getMaxPages()) {
            page = dataStore.getMaxPages();
        }

        return page;
    }
}
