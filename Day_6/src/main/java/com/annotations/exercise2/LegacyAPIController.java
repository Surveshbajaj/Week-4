package com.annotations.exercise2;

// Legacy API class
class LegacyAPI {

    @Deprecated
    void oldFeature() {
        System.out.println("This is the old feature.");
    }

    void newFeature() {
        System.out.println("This is the new feature.");
    }
}

public class LegacyAPIController {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature(); // Calling deprecated method (will show a warning)
        api.newFeature(); // Calling new method
    }
}
