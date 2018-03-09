package com.exxeta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class AppTest {


    App app = new App();

    @Test
    public void shouldWork() {
        assertTrue(true);
    }

    @Test
    public void shouldGetValueForRomanLetter() {
        Integer result = app.getValueFromRomanNumeral("I");
        assertNotNull(result);
    }

    @Test
    public void shouldGetValueForRomanLetterI() {
        Integer result = app.getValueFromRomanNumeral("I");
        Integer expectedValue = 1;
        assertEquals(result, expectedValue);
    }

    @Test
    public void shouldGetValueForRomanLetterV() {
        Integer result = app.getValueFromRomanNumeral("V");
        Integer expectedValue = 5;
        assertEquals(result, expectedValue);
    }

    @Test
    public void shouldGetValueForRomanLetterX() {
        Integer result = app.getValueFromRomanNumeral("X");
        Integer expectedValue = 10;
        assertEquals(result, expectedValue);
    }

    @Test
    public void shouldGetValueForRomanLetterL() {
        Integer result = app.getValueFromRomanNumeral("L");
        Integer expectedValue = 50;
        assertEquals(result, expectedValue);
    }

    @Test
    public void shouldGetValueForRomanLetterC() {
        Integer result = app.getValueFromRomanNumeral("C");
        Integer expectedValue = 100;
        assertEquals(result, expectedValue);
    }
    @Test
    public void shouldGetValueForRomanLetterM() {
        Integer result = app.getValueFromRomanNumeral("M");
        Integer expectedValue = 1000;
        assertEquals(result, expectedValue);
    }
    @Test
    public void shouldGetValueForRomanLetterD() {
        Integer result = app.getValueFromRomanNumeral("D");
        Integer expectedValue = 500;
        assertEquals(result, expectedValue);
    }

    @Test
    public void shouldSubtractLetterAfromLetterB() {
        Integer result = app.substract(1, 5);
        Integer expectedResult = 4;
        assertEquals(result, expectedResult);
    }

    @Test
    public void shouldCalculateRomanLetters() {
        String romanLetter = "MCMCXXXIV";
        Integer result = app.calculate(romanLetter);
        Integer expectedResult = 1984;
        assertEquals(expectedResult, result);
    }
}
