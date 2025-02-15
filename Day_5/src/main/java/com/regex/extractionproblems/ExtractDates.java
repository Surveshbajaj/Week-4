package com.regex.extractionproblems;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDates {

    public static String extractDates(String input) {
        StringBuilder result = new StringBuilder();

        // Regex to match dates in dd/mm/yyyy format
        String regex = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}\\b";

        Pattern pattern = Pattern.compile(regex); // Compile the regex pattern
        Matcher matcher = pattern.matcher(input); // Create matcher for input text

        // Find and extract all valid date occurrences
        while (matcher.find()) {
            result.append(matcher.group()).append(" "); // Append each match
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String input = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020";

        // Extract valid dates from the input text
        String result = extractDates(input);


        if (!result.isEmpty()) {
            System.out.println("Extracted Dates: " + Arrays.toString(result.split(" ")));
        } else {
            System.out.println("No valid dates found.");
        }
    }
}
