package com.setinterface.findsubsets;

import java.util.*;

public class FindSubsets {
    public static boolean isSubset(Set<Integer> subset, Set<Integer> superset) {
        return superset.containsAll(subset);
    }

    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> setB = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));

        System.out.println("Is A a subset of B? " + isSubset(setA, setB));
    }
}

