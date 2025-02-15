package com.regex.advancedproblems;


public class ValidateCreditCardNumber {

    public static String validateCard(String cardNumber) {
        // Remove spaces or dashes
        cardNumber = cardNumber.replaceAll("[\\s-]", "");

        // Regex for Visa (Starts with 4, 16 digits)
        String visaRegex = "^4[0-9]{15}$";

        // Regex for MasterCard (Starts with 5, 16 digits)
        String masterCardRegex = "^5[0-9]{15}$";

        if (cardNumber.matches(visaRegex)) {
            return "Visa";
        } else if (cardNumber.matches(masterCardRegex)) {
            return "MasterCard";
        } else {
            return "Invalid Card Number";
        }
    }

    public static void main(String[] args) {
        // Test card numbers
        String[] cardNumbers = {
                "4111 1111 1111 1111",
                "5123-4567-8901-2345",
                "6011 2345 6789 0123",
        };


        for (String card : cardNumbers) {
            System.out.println(card + " → " + validateCard(card));
        }
    }
}
