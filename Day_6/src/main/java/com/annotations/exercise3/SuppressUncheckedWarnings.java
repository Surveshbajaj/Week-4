package com.annotations.exercise3;

import java.util.ArrayList;

public class SuppressUncheckedWarnings {
    @SuppressWarnings("unchecked") // Suppressing unchecked warnings
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // No generics used

        list.add("Hello");
        list.add(100);
        list.add(3.14);

        System.out.println("ArrayList elements: " + list);
    }
}
