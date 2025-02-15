package com.regex.extractionproblems;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAllCapitalized {



    public static String extractCapitalized(String input) {
        StringBuilder result = new StringBuilder();

        // Regex to match capitalized words
        String regex = "\\b[A-Z][a-z]+\\b"; // Ensures a word starts with uppercase

        Pattern pattern = Pattern.compile(regex); // Compile regex pattern
        Matcher matcher = pattern.matcher(input); // Create matcher for input text

        // Find and extract all capitalized words
        while (matcher.find()) {
            result.append(matcher.group()).append(" "); // Append each match
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Extract capitalized words from input text
        String result = extractCapitalized(input);


        if (!result.isEmpty()) {
            System.out.println("Extracted Capitalized Words: " + Arrays.toString(result.split(" ")));
        }
    }
}
