package datastructures;

import java.util.Arrays;

public class ArrayOperations {

    public static void display(int[] data) {
        System.out.println(Arrays.toString(data));
    }

    public static int[] insert(int[] data, int index, int value) {
        if (index < 0 || index > data.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        int[] result = new int[data.length + 1];

        System.arraycopy(data, 0, result, 0, index);

        result[index] = value;

        System.arraycopy(data, index, result, index + 1, data.length - index);

        return result;
    }

    public static int[] delete(int[] data, int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        int[] result = new int[data.length - 1];

        for (int i = 0, j = 0; i < data.length; i++) {
            if (i != index) {
                result[j++] = data[i];
            }
        }

        return result;
    }

    public static int[] reverse(int[] data) {
        int[] result = data.clone();

        for (int i = 0, j = result.length - 1; i < j; i++, j--) {
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }

        return result;
    }

    public static int findMaximum(int[] data) {
        if (data.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int max = data[0];

        for (int value : data) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    public static int findMinimum(int[] data) {
        if (data.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int min = data[0];

        for (int value : data) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    public static int calculateSum(int[] data) {
        int total = 0;

        for (int value : data) {
            total += value;
        }

        return total;
    }
}

