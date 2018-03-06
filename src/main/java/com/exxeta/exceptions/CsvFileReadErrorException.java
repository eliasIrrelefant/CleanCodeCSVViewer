package com.exxeta.exceptions;

public class CsvFileReadErrorException extends Exception {

    public CsvFileReadErrorException() {
    }

    public CsvFileReadErrorException(String message) {
        super(message);
    }
}
