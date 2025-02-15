package com.regex.advancedproblems;

import java.util.Arrays;
import java.util.regex.*;

public class ExtractProgrammingLanguage {

    public static String extractLanguages(String input) {
       StringBuilder result = new StringBuilder();

        // Regex to match programming languages
        String regex = "\\b(JavaScript|Java|Python|Go)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Find all matches and add to the result
        while (matcher.find()) {
           result.append(matcher.group()).append(" ");
        }


        return result.toString();
    }

    public static void main(String[] args) {

        String input = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Extract programming languages from input text
        String result = extractLanguages(input);

       if(!result.isEmpty()){
           System.out.println("Extracted Languages: "+ Arrays.toString(result.split(" ")));
       }
    }
}
