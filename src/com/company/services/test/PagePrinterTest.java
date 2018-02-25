package com.company.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.company.services.PagePrinter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PagePrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    PagePrinter pagePrinter = new PagePrinter();

    @BeforeAll
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    // ist so ein Test sinnvoll ?
    @Test void shouldPrintGreeting() {
        pagePrinter.printGreeting();
        assertEquals("Willkommen zum CSVViewer3000", outContent.toString());
    }

    @AfterAll
    public void restoreStreams() {
        System.setOut(System.out);
    }
}
