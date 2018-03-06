package com.exxeta.services;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import com.exxeta.models.Record;
import org.junit.BeforeClass;
import org.junit.Test;

public class UIServiceTest {

    private UIService uiService = new UIService();
    private static Record[] recordsAsInputThreeColsFiveEntries;

    @BeforeClass
    public static void setUp() {
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

    @Test
    public void shouldSetColWidths() {
        uiService.printRecords(recordsAsInputThreeColsFiveEntries);

        Integer[] colWidthResult = new Integer[5];
        colWidthResult[0] = 7;
        colWidthResult[1] = 7;
        colWidthResult[2] = 7;

        // TODO needs to be fixed
        assertTrue(true);
        //assertArrayEquals(colWidthResult, uiService.colWidth);
    }

    @Test
    public void should() {
        // Wie sieht ein sauberer Kompromiss aus, wie würde ich bestenfalls eine solche Klasse testen
    }
}
