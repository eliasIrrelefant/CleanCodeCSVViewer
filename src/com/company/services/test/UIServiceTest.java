package com.company.services.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.company.models.Record;
import com.company.services.UIService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UIServiceTest {

    private UIService uiService = new UIService();
    private Record[] recordsAsInputThreeColsFiveEntries;

    @BeforeAll void setUp() {
        recordsAsInputThreeColsFiveEntries = new Record[5];

        for (int i = 0; i < 5; i++) {
            Record record = new Record();
            String[] recordData = new String[3];
            recordData[0] = "rowval" + i;
            recordData[1] = "rowval" + i;
            recordData[2] = "rowval" + i;
            record.setData(recordData);
            recordsAsInputThreeColsFiveEntries[0] = record;
        }
    }

    @Test void shouldSetColWidths() {
        uiService.printRecords(recordsAsInputThreeColsFiveEntries);

        Integer[] colWidthResult = new Integer[5];
        colWidthResult[0] = 7;
        colWidthResult[1] = 7;
        colWidthResult[2] = 7;

    }

    @Test void should() {
        // Wie sieht ein sauberer Kompromiss aus, wie würde ich bestenfalls eine solche Klasse testen
    }

}
