package com.setinterface.checktwosetsareequal;

import java.util.*;

public class CheckTwoSetsAreEqual {
    public static void main(String[] args) {
        // Creating two sets with the same elements but in different order
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        // Checking if both sets are equal (order does not matter in a Set)
        if (set1.equals(set2)) {
            System.out.println("The sets are equal.");
        } else {
            System.out.println("The sets are not equal.");
        }
    }
}
