package com.company.services;

import com.company.Main;
import com.company.models.Record;
import com.company.store.ProcessingData;
import java.util.Arrays;


public class BrowseCsvService {
    UIService uiService = new UIService();


    public void extractFirstPage() {
        String[] extractedPage = extractPage(0);
        Record[] parsedRecord = parseRecords(extractedPage);

        uiService.printRecord(parsedRecord);
    }

    public void extractLastPage() {
        String[] extractedPage = extractPage(ProcessingData.RAWLINES.length / Main.PAGE_ROW_LIMIT);
        Record[] parsedRecord = parseRecords(extractedPage);

        uiService.printRecord(parsedRecord);
    }

    private String[] extractPage(Integer page) {
        Integer firstLine = page * Main.PAGE_ROW_LIMIT;
        Integer lastLine = firstLine + Main.PAGE_ROW_LIMIT;

        return Arrays.copyOfRange(ProcessingData.RAWLINES, firstLine, lastLine);
    }

    // record parser
    private Record[] parseRecords(String[] data) {
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
}
