package com.exxeta.services;

import com.exxeta.store.ProcessingData;

public class DataStore {

    // save headline ...
    void setHeadline(String[] headline) {
        ProcessingData.HEADLINE = headline;
    }

    void setPageNr(Integer pageNr) {
        ProcessingData.CURRENT_PAGE = pageNr;
    }

    void setRawlines(String[] rawlines) {
        // #TODO evaluation
        ProcessingData.RAWLINES = rawlines;
    }

    void setMaxPages(Integer maxPages) {
        ProcessingData.TOTAL_PAGES = maxPages;
    }

    String[] getHeadline() {
        return ProcessingData.HEADLINE;
    }

    Integer getPageNr() {
        return ProcessingData.CURRENT_PAGE;
    }

    String[] getRawlines() {
        return ProcessingData.RAWLINES;
    }

    Integer getMaxPages() {
        return ProcessingData.TOTAL_PAGES;
    }
}
