package com.regex.basicregexproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHexColorCode {

    public static String validHexColorCode(String input) {
        StringBuilder result = new StringBuilder();

        // regex to match valid hex color codes
        String regex = "#[0-9A-Fa-f]{6}\\b";

        Pattern pattern = Pattern.compile(regex); // Compile the regex pattern
        Matcher matcher = pattern.matcher(input); // Create a matcher for the input string

        // Find all matching hex color codes in the input
        while (matcher.find()) {
            result.append(matcher.group()).append(" "); // Append valid hex codes
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Input string containing hex codes (valid and invalid)
        String input = "#FF3337 #AB5647 AC4774 #4363 #87656899";

        // Extract valid hex color codes
        String result = validHexColorCode(input);

        // Print valid hex codes if found
        if (!result.isEmpty()) {
            System.out.println("Valid Hex Color Codes: " + result);
        }
    }
}
