package com.queueinterface.implementstackusingqueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // Move elements except the last one to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // The last element in q1 is the top of the stack
        int topElement = q1.remove();

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Get the top element
    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // Move elements except the last one to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // Get the last element in q1
        int topElement = q1.peek();
        q2.add(q1.remove()); // Move it to q2 to maintain order

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Top element: " + stack.top());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}

