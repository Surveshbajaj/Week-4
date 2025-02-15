package com.regex.basicregexproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUsername {
    public static void main(String[] args) {
        String regex = "[a-zA-Z][a-zA-Z0-9_]{4,14}";
        Pattern pattern = Pattern.compile(regex);
        String input = "sarvesh d 3534fggon vivek deepanshu 46746sdvfiso  ";
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            System.out.println("Valid name: "+ matcher.group());
        }
    }
}
