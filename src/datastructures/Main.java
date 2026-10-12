package datastructures;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== DATA STRUCTURE GRAPH ANALYZER =====");
            System.out.println("1. Array Operations");
            System.out.println("2. Searching Algorithms");
            System.out.println("3. Stack Operations");
            System.out.println("4. Queue Operations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    arrayMenu();
                    break;
                case 2:
                    searchingMenu();
                    break;
                case 3:
                    stackMenu();
                    break;
                case 4:
                    queueMenu();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static int[] inputArray() {
        System.out.print("Enter the number of elements: ");
        int size = readInt();

        if (size < 0) {
            System.out.println("Size cannot be negative.");
            return new int[0];
        }

        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            data[i] = readInt();
        }

        return data;
    }

    private static void arrayMenu() {
        int[] data = inputArray();
        int choice;

        do {
            System.out.println("\n--- Array Operations ---");
            System.out.println("1. Display Array");
            System.out.println("2. Insert Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Reverse Array");
            System.out.println("5. Find Maximum");
            System.out.println("6. Find Minimum");
            System.out.println("7. Calculate Sum");
            System.out.println("8. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = readInt();

            try {
                switch (choice) {
                    case 1:
                        ArrayOperations.display(data);
                        break;

                    case 2:
                        System.out.print("Enter index for insertion: ");
                        int insertIndex = readInt();
                        System.out.print("Enter value: ");
                        int value = readInt();
                        data = ArrayOperations.insert(data, insertIndex, value);
                        System.out.println("Element inserted.");
                        ArrayOperations.display(data);
                        break;

                    case 3:
                        System.out.print("Enter index to delete: ");
                        int deleteIndex = readInt();
                        data = ArrayOperations.delete(data, deleteIndex);
                        System.out.println("Element deleted.");
                        ArrayOperations.display(data);
                        break;

                    case 4:
                        data = ArrayOperations.reverse(data);
                        System.out.println("Array reversed:");
                        ArrayOperations.display(data);
                        break;

                    case 5:
                        System.out.println("Maximum: "
                                + ArrayOperations.findMaximum(data));
                        break;

                    case 6:
                        System.out.println("Minimum: "
                                + ArrayOperations.findMinimum(data));
                        break;

                    case 7:
                        System.out.println("Sum: "
                                + ArrayOperations.calculateSum(data));
                        break;

                    case 8:
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 8);
    }

    private static void searchingMenu() {
        int[] data = inputArray();

        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Choose a search method: ");
        int choice = readInt();

        System.out.print("Enter the value to search for: ");
        int target = readInt();

        if (choice == 1) {
            int index = Searching.linearSearch(data, target);
            showSearchResult(index);
        } else if (choice == 2) {
            int[] sortedData = data.clone();
            Arrays.sort(sortedData);

            System.out.println("Sorted array used for binary search:");
            ArrayOperations.display(sortedData);

            int index = Searching.binarySearch(sortedData, target);
            showSearchResult(index);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void showSearchResult(int index) {
        if (index == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + index);
        }
    }

    private static void stackMenu() {
        System.out.print("Enter stack capacity: ");
        int capacity = readInt();

        if (capacity <= 0) {
            System.out.println("Capacity must be greater than zero.");
            return;
        }

        Stack stack = new Stack(capacity);
        int choice;

        do {
            System.out.println("\n--- Stack Operations ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Check if Empty");
            System.out.println("6. Check if Full");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    stack.push(readInt());
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Empty: " + stack.isEmpty());
                    break;
                case 6:
                    System.out.println("Full: " + stack.isFull());
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);
    }

    private static void queueMenu() {
        System.out.print("Enter queue capacity: ");
        int capacity = readInt();

        if (capacity <= 0) {
            System.out.println("Capacity must be greater than zero.");
            return;
        }

        Queue queue = new Queue(capacity);
        int choice;

        do {
            System.out.println("\n--- Queue Operations ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Check if Empty");
            System.out.println("6. Check if Full");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    queue.enqueue(readInt());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Empty: " + queue.isEmpty());
                    break;
                case 6:
                    System.out.println("Full: " + queue.isFull());
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);
    }
}