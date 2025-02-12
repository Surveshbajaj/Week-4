package com.queueinterface.circularbuffersimulation;
class CircularBuffer {
    private int[] buffer;
    private int capacity;
    private int size;
    private int front;
    private int rear;

    // Constructor to initialize the circular buffer
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    // Enqueue an element (overwrite the oldest if full)
    public void enqueue(int value) {
        if (isFull()) {
            // Overwrite oldest element and move front pointer
            front = (front + 1) % capacity;
        } else {
            size++;
        }

        buffer[rear] = value; // Insert element
        rear = (rear + 1) % capacity; // Move rear pointer
    }

    // Dequeue the oldest element
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Buffer is empty");
        }

        int removedValue = buffer[front]; // Get front element
        front = (front + 1) % capacity; // Move front pointer
        size--;

        return removedValue;
    }

    // Peek at the front element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Buffer is empty");
        }
        return buffer[front];
    }

    // Check if the buffer is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the buffer is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Display buffer contents (for debugging)
    public void display() {
        System.out.print("Buffer: ");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        cb.display();

        cb.enqueue(4);
        cb.display();

        System.out.println("Dequeued: " + cb.dequeue());
        cb.display();

        cb.enqueue(5);
        cb.display();

        System.out.println("Front element: " + cb.peek());
    }
}
