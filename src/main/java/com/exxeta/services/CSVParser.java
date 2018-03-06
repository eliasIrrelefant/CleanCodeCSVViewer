package com.exxeta.services;

import com.exxeta.models.Record;
import com.exxeta.store.ApplicationParameters;

public class CSVParser {

    public Record[] parseRawlines(String[] data) {
        Record[] recordResult = new Record[data.length];
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                continue;
            }

            Record record = new Record();
            record.setData(data[i].split(ApplicationParameters.SEPARATOR));
            recordResult[i] = record;
        }

        return recordResult;
    }

}
