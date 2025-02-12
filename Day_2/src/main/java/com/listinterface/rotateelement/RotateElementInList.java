package com.listinterface.rotateelement;

import java.util.ArrayList;

public class RotateElementInList {
    // Function to rotate the array by k positions
    public static void rotate( ArrayList<Integer> arr, int k) {
        int n = arr.size();
        k = k % n; // Handle cases where k > n

        //  Reverse the whole array
        reverse(arr, 0, n - 1);

        // Reverse first k elements
        reverse(arr, 0, k - 1);

        //  Reverse remaining n-k elements
        reverse(arr, k, n - 1);
    }

    // Helper function to reverse part of an array
    private static void reverse( ArrayList<Integer> arr, int left, int right) {
        while (left < right) {
            int temp = arr.get(left);
            arr.set(left,arr.get(right));
            arr.set(right,temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        arr.add(50);
        int k = 3;

        System.out.println("Original Array: " + arr);
        rotate(arr, k);
        System.out.println("Rotated Array: " + arr);
    }
}
