package com.regex.advancedproblems;

import java.util.regex.*;

public class ValidateIPAddress {

    public static boolean isValidIPv4(String ip) {
        // Regular expression for a valid IPv4 address
        String regex = "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}"
                + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        return matcher.matches(); // Returns true if the IP is valid
    }

    public static void main(String[] args) {
        // Test cases
        String[] testIPs = {
                "192.168.1.1",
                "255.255.255.255",
                "10.0.0.1",
                "256.100.50.25",
        };

        for (String ip : testIPs) {
            System.out.println(ip + " is valid: " + isValidIPv4(ip));
        }
    }
}
