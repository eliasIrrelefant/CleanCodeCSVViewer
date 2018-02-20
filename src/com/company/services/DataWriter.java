package com.company.services;

import com.company.store.ProcessingData;

// #TODO Data Store
public class DataWriter {

    // GETTER

    // save headline ...
    void setHeadline(String[] headline) {
        ProcessingData.HEADLINE = headline;
    }

    void setPageNr(Long pageNr) {
        ProcessingData.CURRENT_PAGE = pageNr;
    }

    void setRawlines(String[] rawlines) {
        // #TODO evaluation
        ProcessingData.RAWLINES = rawlines;
    }



}
