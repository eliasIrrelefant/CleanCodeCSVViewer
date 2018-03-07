package com.company.services;

import com.company.models.Record;
import com.company.store.ProcessingData;
import java.util.Scanner;

public class UIService {
    private Scanner input = new Scanner(System.in);
    private DataStore dataStore = new DataStore();

    public void printGreeting() {
        System.out.println("Willkommen zum CSVViewer3000");
    }

    public Character awaitInput() {
        System.out.println("F)irst P)rev N)ext L)ast E)xit");
        // #TODO validation and feedback to user
        return Character.toUpperCase(input.next().charAt(0));
    }

    public String getFilename() {
        System.out.println("Bitte geben Sie den Namen der CSV-Datei ein");
        // #TODO validation, .csv ending
        return input.next();
    }

    public void printRecords(Record[] input) {
        Integer[] columnWidth = determineColumnWidths(input);
        printHeadline(input, columnWidth);
        printRecordEntries(input, columnWidth);
    }

    private void printHeadline(Record[] input, Integer[] columnWidth) {
        printLineSeparatorForInput(input, columnWidth);

        String[] head = ProcessingData.HEADLINE;
        for (int i = 0; i < head.length; i++) {
            System.out.print(" # " + head[i]);
            determinedWhitespace(head[i].length(), columnWidth[i]);
        }
        System.out.print(" #");
        System.out.println();
    }

    private void printRecordEntries(Record[] input, Integer[] columnWidth) {
        printLineSeparatorForInput(input, columnWidth);
        for (Record entry : input) {
            if (entry == null) {
                continue;
            }

            for (int i = 0; i < entry.getData().length; i++) {
                String entryToPrint = entry.getData()[i];
                //return type auf int
                determinedWhitespace(entry.getData()[i].length(), columnWidth[i]);
                //entryToPrint =  fillWithWhitespace(entryToPrint, numberOfSpaces)

                System.out.print(" # " + entryToPrint);
            }
            System.out.print(" #");
            System.out.println();
            printLineSeparatorForInput(input, columnWidth);
        }
    }

    // ist es sinnvoll diese methode in separate klasse zu extrahieren um diese Testen zu können ?
    private void determinedWhitespace(Integer wordLength, Integer columnWidth) {
        if (columnWidth > wordLength) {
            Integer charDiff = columnWidth - wordLength;
            for (int i = 0; i < charDiff; i++) {
                System.out.print(" ");
            }
        }
    }

    // ist es sinnvoll diese methode in separate klasse zu extrahieren um diese Testen zu können ?
    private void printLineSeparatorForInput(Record[] input, Integer[] columnWidth) {
        System.out.print(" ");
        for (int x = 0; x < input[0].getData().length; x++) {
            System.out.print("+");
            // +2 for the empty spaces
            for (int i = 0; i < columnWidth[x] + 2; i++) {
                System.out.print("#");
            }
        }
        System.out.print("+");
        System.out.println();
    }

    private Integer[] determineColumnWidths(Record[] input) {
        Integer[] columnWidth = new Integer[input[0].getData().length];

        columnWidth = compareColumnWidthOfSingleEntry(dataStore.getHeadline(), columnWidth);

        for (Record entry : input) {
            if (entry == null) {
                continue;
            }

            columnWidth = compareColumnWidthOfSingleEntry(entry.getData(), columnWidth);
        }

        return columnWidth;
    }

    private Integer[] compareColumnWidthOfSingleEntry(String[] entry, Integer[] columnWidth) {
        Integer[] result = new Integer[columnWidth.length];
        System.arraycopy(columnWidth, 0, result, 0, columnWidth.length);

        for (int i = 0; i < entry.length; i++) {
            if (result[i] == null) {
                result[i] = 0;
            }

            if (entry[i].length() > result[i]) {
                result[i] = entry[i].length();
            }
        }
        return result;
    }
}
