package datastructures;
public class Queue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Queue(int capacity) {

        this.capacity = capacity;
        queue = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(int value) {

        if (size == capacity) {
            System.out.println("Queue Overflow: Queue is full.");
            return;
        }

        rear = (rear + 1) % capacity;

        queue[rear] = value;
        size++;

        System.out.println("Value enqueued: " + value);
    }

    public void dequeue() {

        if (size == 0) {
            System.out.println("Queue Underflow: Queue is empty.");
            return;
        }

        int value = queue[front];

        front = (front + 1) % capacity;
        size--;

        System.out.println("Value dequeued: " + value);
    }

    public void peek() {

        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Front value: " + queue[front]);
    }

    public void display() {

        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("\nQueue elements:");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % capacity;

            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}