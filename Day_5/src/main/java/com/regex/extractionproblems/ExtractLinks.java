package com.regex.extractionproblems;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinks {

    public static String extractLinks(String input) {
        StringBuilder result = new StringBuilder(); // Efficient string handling

        // Regex to match valid URLs (http/https)
        String regex = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b";

        Pattern pattern = Pattern.compile(regex); // Compile regex pattern
        Matcher matcher = pattern.matcher(input); // Create matcher for input text

        // Find and extract all valid URLs
        while (matcher.find()) {
            result.append(matcher.group()).append(" "); // Append each found link
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String input = "Visit https://www.google.com and http://example.org for more info.";

        // Extract valid URLs from input text
        String result = extractLinks(input);


        if (!result.isEmpty()) {
            System.out.println("Extracted Links: " + Arrays.toString(result.split(" ")));
        }
    }
}
