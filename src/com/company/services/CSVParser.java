package com.company.services;

import com.company.models.Record;
import com.company.store.ApplicationParameters;

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
