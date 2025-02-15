package com.regex.replaceandmodifystrings;

import java.util.ArrayList;
import java.util.List;

public class CensorBadWords {


    public static String replaceBadWord(String input) {
        List<String> list = new ArrayList<>(); // List to store bad words


        list.add("damn");
        list.add("stupid");

        // Replace each bad word with "****"
        for (String word : list) {
            input = input.replaceAll("(?i)\\b" + word + "\\b", "****"); // Case-insensitive whole-word match
        }

        return input;
    }

    public static void main(String[] args) {

        String input = "This is a damn bad example with some stupid words.";

        // Print original text
        System.out.println("Original: " + input);

        String result = replaceBadWord(input);

        // Print modified text
        System.out.println("Modify: " + result);
    }
}
