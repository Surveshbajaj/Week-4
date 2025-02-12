package com.setinterface.symmetricdifference;

import java.util.*;

public class SymmetricDifference {
    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2); // Union

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // Intersection

        union.removeAll(intersection); // Union - Intersection
        return union;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
    }
}

