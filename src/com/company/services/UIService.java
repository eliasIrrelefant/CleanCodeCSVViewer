package com.company.services;

import com.company.models.Record;
import java.util.Scanner;

public class UIService {

    // header zeile fehlt noch

    private Scanner input = new Scanner(System.in);
    Integer[] colWidth;

    public void printGreeting() {
        System.out.println("Willkommen zum CSVViewer3000");
    }

    public Character awaitInput() {
        System.out.println("F)irst P)rev N)ext L)ast E)xit");
        // #TODO validation
        return input.next().charAt(0);
    }

    public String getFilename() {
        System.out.println("Bitte geben Sie den Namen der CSV-Datei ein");
        // #TODO validation
        return input.next();
    }


    public void printRecord(Record[] input) {
        determineColWidths(input);
        // #TODO print head
        printRecordEntries(input);
    }

    private void printRecordEntries(Record[] input) {
        printLineSeparatorForInput(input);
        for (Record entry : input) {
            if (entry == null) {
                continue;
            }

            for (int i = 0; i < entry.getData().length; i++) {
                System.out.print(" # " + entry.getData()[i]);
                determinedWhitespace(entry.getData()[i].length(), i);
            }
            System.out.print(" #");
            System.out.println();
            printLineSeparatorForInput(input);
        }
    }

    private void determinedWhitespace(Integer wordLengh, Integer colIndex) {
        if (colWidth[colIndex] > wordLengh) {
            Integer charDiff = colWidth[colIndex] - wordLengh;
            for (int i = 0; i < charDiff; i++) {
                System.out.print(" ");
            }
        }
    }

    private void printLineSeparatorForInput(Record[] input) {
        System.out.print(" ");
        for (int x = 0; x < input[0].getData().length; x++) {
            System.out.print("+");
            // +2 for the empty spaces
            for (int i = 0; i < colWidth[x] + 2; i++) {
                System.out.print("#");
            }
        }
        System.out.print("+");
        System.out.println();
    }

    private void determineColWidths(Record[] input) {
        colWidth = new Integer[input[0].getData().length];

        for (Record entry : input) {
            if (entry == null) {
                continue;
            }

            for (int i = 0; i < entry.getData().length; i++) {
                if (colWidth[i] == null) {
                    colWidth[i] = 0;
                }

                if (entry.getData()[i].length() > colWidth[i]) {
                    colWidth[i] = entry.getData()[i].length();
                }
            }
        }
    }


}
