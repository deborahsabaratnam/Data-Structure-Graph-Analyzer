package datastructures;

public class Stack {

    private int[] stack;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int value) {

        if (top == capacity - 1) {
            System.out.println("Stack Overflow: Stack is full.");
            return;
        }

        top++;
        stack[top] = value;

        System.out.println("Value pushed: " + value);
    }

    public void pop() {

        if (top == -1) {
            System.out.println("Stack Underflow: Stack is empty.");
            return;
        }

        int value = stack[top];
        top--;

        System.out.println("Value popped: " + value);
    }

    public void peek() {

        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Top value: " + stack[top]);
    }

    public void display() {

        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("\nStack elements:");

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}