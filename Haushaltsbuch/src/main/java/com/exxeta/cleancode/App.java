package com.exxeta.cleancode;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        OperatorService operatorService = new OperatorService();

        operatorService.processParameters(args);

        System.out.println("Hello World!");

    }
}
