package datastructures;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

private static final Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {

    int choice;

    do {
        System.out.println("\n====================================");
        System.out.println("     DATA STRUCTURE GRAPH ANALYZER");
        System.out.println("====================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Searching Algorithms");
        System.out.println("3. Stack Operations");
        System.out.println("4. Queue Operations");
        System.out.println("5. Linked List Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance Comparison");
        System.out.println("8. Exit");
        System.out.println("====================================");
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
                linkedListMenu();
                break;

            case 6:
                graphMenu();
                break;

            case 7:
                PerformanceComparison.compareSearchingAlgorithms();
                break;

            case 8:
                System.out.println("Thank you for using the program!");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }

    } while (choice != 8);

    scanner.close();
}

// Read an integer safely
private static int readInt() {
    while (!scanner.hasNextInt()) {
        System.out.print("Please enter a valid integer: ");
        scanner.next();
    }

    int value = scanner.nextInt();
    scanner.nextLine();
    return value;
}

// Read a string
private static String readString(String message) {
    System.out.print(message);
    return scanner.nextLine().trim();
}

// Input an integer array
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

// ================= ARRAY OPERATIONS =================

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
                    System.out.print("Enter insertion index: ");
                    int insertIndex = readInt();

                    System.out.print("Enter value: ");
                    int insertValue = readInt();

                    data = ArrayOperations.insert(
                            data, insertIndex, insertValue);

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
                    System.out.println("Reversed array:");
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

        } catch (IllegalArgumentException
                | IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

    } while (choice != 8);
}

// ================= SEARCHING ALGORITHMS =================

private static void searchingMenu() {

    int[] data = inputArray();

    System.out.println("\n--- Searching Algorithms ---");
    System.out.println("1. Linear Search");
    System.out.println("2. Binary Search");
    System.out.print("Enter your choice: ");

    int choice = readInt();

    System.out.print("Enter the value to search: ");
    int target = readInt();

    int index;

    if (choice == 1) {
        index = Searching.linearSearch(data, target);
        showSearchResult(index);

    } else if (choice == 2) {

        int[] sortedData = data.clone();
        Arrays.sort(sortedData);

        System.out.println("Sorted array used for binary search:");
        ArrayOperations.display(sortedData);

        index = Searching.binarySearch(sortedData, target);
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

// ================= STACK OPERATIONS =================

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
                System.out.println("Stack empty: "
                        + stack.isEmpty());
                break;

            case 6:
                System.out.println("Stack full: "
                        + stack.isFull());
                break;

            case 7:
                break;

            default:
                System.out.println("Invalid choice.");
        }

    } while (choice != 7);
}

// ================= QUEUE OPERATIONS =================

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
                System.out.println("Queue empty: "
                        + queue.isEmpty());
                break;

            case 6:
                System.out.println("Queue full: "
                        + queue.isFull());
                break;

            case 7:
                break;

            default:
                System.out.println("Invalid choice.");
        }

    } while (choice != 7);
}

// ================= LINKED LIST OPERATIONS =================

private static void linkedListMenu() {

    LinkedList list = new LinkedList();
    int choice;

    do {
        System.out.println("\n--- Linked List Operations ---");
        System.out.println("1. Insert at Beginning");
        System.out.println("2. Insert at End");
        System.out.println("3. Delete Element");
        System.out.println("4. Search Element");
        System.out.println("5. Display Linked List");
        System.out.println("6. Check if Empty");
        System.out.println("7. Display Size");
        System.out.println("8. Back to Main Menu");
        System.out.print("Enter your choice: ");

        choice = readInt();

        switch (choice) {
            case 1:
                System.out.print("Enter value: ");
                list.insertAtBeginning(readInt());
                System.out.println("Element inserted.");
                break;

            case 2:
                System.out.print("Enter value: ");
                list.insertAtEnd(readInt());
                System.out.println("Element inserted.");
                break;

            case 3:
                System.out.print("Enter value to delete: ");
                list.delete(readInt());
                break;

            case 4:
                System.out.print("Enter value to search: ");
                int searchValue = readInt();

                if (list.search(searchValue)) {
                    System.out.println("Element found.");
                } else {
                    System.out.println("Element not found.");
                }
                break;

            case 5:
                list.display();
                break;

            case 6:
                System.out.println("List empty: "
                        + list.isEmpty());
                break;

            case 7:
                System.out.println("List size: " + list.size());
                break;

            case 8:
                break;

            default:
                System.out.println("Invalid choice.");
        }

    } while (choice != 8);
}

// ================= GRAPH OPERATIONS =================

private static void graphMenu() {

    Graph graph = new Graph();
    int choice;

    do {
        System.out.println("\n--- Graph Operations ---");
        System.out.println("1. Add Vertex");
        System.out.println("2. Add Edge");
        System.out.println("3. Remove Vertex");
        System.out.println("4. Remove Edge");
        System.out.println("5. Display Graph");
        System.out.println("6. Search Vertex");
        System.out.println("7. Breadth-First Search (BFS)");
        System.out.println("8. Depth-First Search (DFS)");
        System.out.println("9. Back to Main Menu");
        System.out.print("Enter your choice: ");

        choice = readInt();

        switch (choice) {
            case 1: {
                String vertex = readString("Enter vertex name: ");
                graph.addVertex(vertex);
                break;
            }

            case 2: {
                String from = readString("Enter starting vertex: ");
                String to = readString("Enter connected vertex: ");
                graph.addEdge(from, to);
                break;
            }

            case 3: {
                String vertex = readString("Enter vertex to remove: ");
                graph.removeVertex(vertex);
                break;
            }

            case 4: {
                String from = readString("Enter starting vertex: ");
                String to = readString("Enter connected vertex: ");
                graph.removeEdge(from, to);
                break;
            }

            case 5:
                graph.displayGraph();
                break;

            case 6: {
                String vertex = readString("Enter vertex to search: ");
                graph.searchVertex(vertex);
                break;
            }

            case 7: {
                String start = readString("Enter starting vertex for BFS: ");
                graph.bfs(start);
                break;
            }

            case 8: {
                String start = readString("Enter starting vertex for DFS: ");
                graph.dfs(start);
                break;
            }

            case 9:
                break;

            default:
                System.out.println("Invalid choice.");
        }

    } while (choice != 9);
}

}