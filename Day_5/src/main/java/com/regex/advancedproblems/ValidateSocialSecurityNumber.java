package com.regex.advancedproblems;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSocialSecurityNumber {
    public static String ValidateSSN(String input) {
        StringBuilder result = new StringBuilder();

        // Regex to match Validate a Social Security Number:
        String regex = "\\b(?!666|000|9\\d{2})[0-8]\\d{2}-(?!00)\\d{2}-(?!0000)\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Find all matches and add to the result
        while (matcher.find()) {
            result.append(matcher.group()).append(" ");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String input = "My SSN is 123-45-6789";

        // Extract Social Security Number from input text
        String result = ValidateSSN(input);

        if(!result.isEmpty()){
            System.out.println("Extracted Validate a Social Security Number: "+ Arrays.toString(result.split(" ")));
        }
    }
}
