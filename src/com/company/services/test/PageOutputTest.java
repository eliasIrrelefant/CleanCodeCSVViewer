package com.company.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.company.services.PageOutput;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PageOutputTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PageOutput pageOutput = new PageOutput();

    @BeforeAll
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    // ist so ein Test sinnvoll ?
    @Test void shouldPrintGreeting() {
        pageOutput.printGreeting();
        assertEquals("Willkommen zum CSVViewer3000\n", outContent.toString());
    }

    // hier wären integrationstest sinnvoll die überprüfen ob z.b. die richte seitenzahl geschrieben wird.
    // dazu müsste ich dann die jeweiligen services mocken und deren funktionen emulieren

    @AfterAll
    void restoreStreams() {
        System.setOut(System.out);
    }
}
