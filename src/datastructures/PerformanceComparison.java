package datastructures;

public class PerformanceComparison {

public static void compareSearchingAlgorithms() {

    int[] sizes = {1000, 10000, 50000};
    int repetitions = 100;

    System.out.println("\n===== SEARCHING PERFORMANCE COMPARISON =====");
    System.out.printf("%-20s %-15s %-20s%n",
            "Algorithm", "Array Size", "Average Time (ns)");
    System.out.println("-------------------------------------------------------");

    for (int size : sizes) {

        int[] data = new int[size];

        // Create a sorted array.
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }

        // Search for a value that is not present.
        int target = -1;

        // Warm up both searching methods.
        for (int i = 0; i < 10; i++) {
            Searching.linearSearch(data, target);
            Searching.binarySearch(data, target);
        }

        long linearStart = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            Searching.linearSearch(data, target);
        }

        long linearEnd = System.nanoTime();

        long binaryStart = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            Searching.binarySearch(data, target);
        }

        long binaryEnd = System.nanoTime();

        long linearAverage =
                (linearEnd - linearStart) / repetitions;

        long binaryAverage =
                (binaryEnd - binaryStart) / repetitions;

        System.out.printf("%-20s %-15d %-20d%n",
                "Linear Search", size, linearAverage);

        System.out.printf("%-20s %-15d %-20d%n",
                "Binary Search", size, binaryAverage);

        System.out.println();
    }

    System.out.println("Conclusion:");
    System.out.println("Linear Search checks elements one by one.");
    System.out.println("Binary Search repeatedly divides the search range.");
    System.out.println("Binary Search is generally faster for sorted arrays.");
    System.out.println("\nNote: Execution times are approximate and may vary.");
    System.out.println("The target value is not present in the array.");
}

}