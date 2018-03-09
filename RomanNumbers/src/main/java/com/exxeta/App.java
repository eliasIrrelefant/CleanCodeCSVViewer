package com.exxeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {

    static Map<String, Integer> DIGITS;

    static {
        DIGITS = new HashMap<String, Integer>();
        DIGITS.put("I", 1);
        DIGITS.put("V", 5);
        DIGITS.put("X", 10);
        DIGITS.put("L", 50);
        DIGITS.put("C", 100);
        DIGITS.put("D", 500);
        DIGITS.put("M", 1000);
    }

    public static void main(String[] args) {


    }

    Integer calculate(String romanLetters) {

        List<Integer> subtractionSum = new ArrayList<Integer>();
        StringBuilder stringBuilder = new StringBuilder(romanLetters);

        for(int index = 1; index < romanLetters.length() - 1; index++) {
            Integer right = getValueFromRomanNumeral(String.valueOf(romanLetters.charAt(index)));
            Integer left = getValueFromRomanNumeral(String.valueOf(romanLetters.charAt(index-1)));

            if(left < right) {
                subtractionSum.add(substract(left, right));
                stringBuilder.deleteCharAt(index);
                stringBuilder.deleteCharAt(index-1);
            }
        }

        String remainingRomanLetters = stringBuilder.toString();
        Integer sum = 0;

        for(char letter: remainingRomanLetters.toCharArray()) {
            sum += getValueFromRomanNumeral(String.valueOf(letter));
        }

        for(Integer value: subtractionSum) {
            sum += value;
        }
        return sum;
    }


    List<String> determinePositionsToLetters(String inputRomanNumber) {
        List<String> resultList = new ArrayList<String>();

        char[] charArray = inputRomanNumber.toCharArray();

        for (char letter : charArray) {
            resultList.add(String.valueOf(letter));
        }

        return resultList;
    }

    Integer getValueFromRomanNumeral(String roman) {
        return DIGITS.get(roman);
    }

    Integer substract(Integer left, Integer right) {
        return right - left;
    }




}
