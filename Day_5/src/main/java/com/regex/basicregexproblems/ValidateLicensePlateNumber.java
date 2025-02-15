package com.regex.basicregexproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLicensePlateNumber {
    public static void main(String[] args) {
        String regex = "[A-Z]{2}[0-9]{4}";
        Pattern pattern = Pattern.compile(regex);
        String input = "AS1234 DS6564 5366AS re545 A32";
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            System.out.println("Valid license: "+ matcher.group());
        }
    }
}
