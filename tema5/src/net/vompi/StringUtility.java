package net.vompi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    public String removeWhitespaces(String string){
        return string.replaceAll("\\s+","");
    }

    public String convertNumbersInLiteralsFromStringToDigits(String stringToChange){
        String[] wordsArray = stringToChange.split(" ");
        StringBuilder sb = new StringBuilder();

        for ( String ss : wordsArray) {

            //System.out.println(ss);
            if(digitsMap.containsKey(ss.toLowerCase())) {
                ss = digitsMap.get(ss.toLowerCase());
            }

            sb.append(ss + " ");
        }
        return sb.toString();
        /*stringToChange = stringToChange.toLowerCase();
        for(String key : digitsMap.keySet()){
            stringToChange = stringToChange.replace(key, digitsMap.get(key));
        }
        return stringToChange;*/
    }

}
