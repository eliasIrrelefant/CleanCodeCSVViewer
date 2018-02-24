package com.company.services;

import com.company.Main;
import com.company.models.Record;
import java.util.Arrays;

public class BrowseCsvService {
    DataStore dataStore = new DataStore();

    public String[] extractPage(Integer page) {
        Integer firstLine = page * Main.PAGE_ROW_LIMIT;
        Integer lastLine = firstLine + Main.PAGE_ROW_LIMIT;

        return Arrays.copyOfRange(dataStore.getRawlines(), firstLine, lastLine);
    }

    // record parser
    public Record[] parseRecords(String[] data) {
        Record[] recordResult = new Record[data.length];
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                continue;
            }

            Record record = new Record();
            record.setData(data[i].split(Main.SEPARATOR));
            recordResult[i] = record;
        }

        return recordResult;
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
