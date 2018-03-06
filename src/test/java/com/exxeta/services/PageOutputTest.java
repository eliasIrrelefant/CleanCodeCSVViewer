package com.exxeta.services;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PageOutputTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PageOutput pageOutput = new PageOutput();

    @BeforeClass
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    // ist so ein Test sinnvoll ?
    @Test
    public void shouldPrintGreeting() {
        pageOutput.printGreeting();
        assertEquals("Willkommen zum CSVViewer3000\n", outContent.toString());
    }

    // hier wären integrationstest sinnvoll die überprüfen ob z.b. die richte seitenzahl geschrieben wird.
    // dazu müsste ich dann die jeweiligen services mocken und deren funktionen emulieren

    @AfterClass
    public void restoreStreams() {
        System.setOut(System.out);
    }
}
