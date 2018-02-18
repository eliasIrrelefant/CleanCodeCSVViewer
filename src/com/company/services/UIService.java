package com.company.services;

import java.util.List;
import java.util.Scanner;

public class UIService {

    private Scanner input = new Scanner(System.in);

    public void initText() {
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

    public void displayParsedCsvFileInput(Integer limit, List<String[]> input) {
        for (int i=0; i<limit; i++) {

        }
    }

}
