package com.regex.advancedproblems;

import java.util.Arrays;
import java.util.regex.*;

public class ExtractCurrencyValues {

    public static String extractCurrencyValues(String input) {
        StringBuilder result = new StringBuilder();

        // Regex to match Currency Values:
        String regex = "\\$?\\d+(\\.\\d{2})?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Find all matches and add to the result
        while (matcher.find()) {
            result.append(matcher.group()).append(" ");
        }


        return result.toString();
    }

    public static void main(String[] args) {

        String input = "The price is $45.99, and the discount is 10.50.";

        // Extract Currency Values:from input text
        String result = extractCurrencyValues(input);

        if(!result.isEmpty()){
            System.out.println("Extracted Currency Values: "+ Arrays.toString(result.split(" ")));
        }
    }
}
