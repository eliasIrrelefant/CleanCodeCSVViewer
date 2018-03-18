package com.exxeta.cleancode.exceptions;

public class CsvFileReadErrorException extends Exception {

    public CsvFileReadErrorException() {
    }

    public CsvFileReadErrorException(String message) {
        super(message);
    }
}
