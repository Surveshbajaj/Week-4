package com.regex.extractionproblems;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAllEmailAddressesfromText {

    public static String ExtractEmail(String input) {
        // Regex to match valid email addresses
        String regex = "\\b[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}\\b";
        StringBuilder result = new StringBuilder();

        Pattern pattern = Pattern.compile(regex); // Compile regex pattern
        Matcher matcher = pattern.matcher(input); // Create matcher for input text

        // Find and extract all email addresses
        while (matcher.find()) {
            result.append(matcher.group()).append(" "); // Append found emails
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Contact us at support@example.com and info@company.org";

        // Extract valid email addresses from the input text
        String result = ExtractEmail(input);

        // Print extracted email addresses as an array format
        if (!result.isEmpty()) {
            System.out.println("Extracted Emails: " + Arrays.toString(result.split(" ")));
        }
    }
}
