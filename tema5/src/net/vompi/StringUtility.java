package net.vompi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dani on 11/30/16.
 */
public class StringUtility {

    private Map<String, String> digitsMap = new HashMap<>();

    public StringUtility(){
        digitsMap.put("zero", "0");
        digitsMap.put("one", "1");
        digitsMap.put("two", "2");
        digitsMap.put("three", "3");
        digitsMap.put("four", "4");
        digitsMap.put("five", "5");
        digitsMap.put("six", "6");
        digitsMap.put("seven", "7");
        digitsMap.put("eight", "8");
        digitsMap.put("nine", "9");

    }

    /**
     * This method receives a string and removes every whitespace from it.
     *
     * @param stringToFormat the string to be formatted
     * @return the received string without whitespaces
     * @throws IllegalArgumentException if stringToFormat is null or empty
     */
    public String removeWhitespaces(String stringToFormat) throws IllegalArgumentException{
        if (stringToFormat == null) {
            throw new IllegalArgumentException("String must not be null.");
        }
        if (stringToFormat.length() == 0) {
            throw new IllegalArgumentException("String must not be empty.");
        }
        return stringToFormat.replaceAll("\\s+","");
    }

    /**
     * This method receives a string and finds all occurrences of a digit written as
     * a word(eg. "one" instead of "1"), changing them with the corresponding digit.
     *
     * @param stringToFormat the string to be formatted
     * @return the received string with digits instead of the words representing them
     * @throws IllegalArgumentException if stringToFormat is null or empty
     */

    public String convertNumbersInLiteralsFromStringToDigits(String stringToFormat) throws IllegalArgumentException{
        if (stringToFormat == null) {
            throw new IllegalArgumentException("String must not be null.");
        }
        if (stringToFormat.length() == 0) {
            throw new IllegalArgumentException("String must not be empty.");
        }
        String[] wordsArray = stringToFormat.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for ( String substring : wordsArray) {
            if(digitsMap.containsKey(substring.toLowerCase())) {
                substring = digitsMap.get(substring.toLowerCase());
            }
            stringBuilder.append(substring + " ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

}
