package com.deemo.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciSearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        // List<int[]> ints = Arrays.asList(arr);
        // System.out.println(ints);

        System.out.println(search(arr, 88));
        System.out.println(search(arr, -1));
    }

    private static int[] fibonacciArray(int length) {
        if (length <= 0) {
            throw new RuntimeException();
        }

        if (length == 1) {
            return new int[] {1};
        }

        List<Integer> list = new ArrayList<>();
        int k = 1;
        int fibValue = 1;
        list.add(fibValue);
        while (length > fibValue - 1) {
            fibValue = fibonacciValue(++k);
            list.add(fibValue);
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    private static int fibonacciValue(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fibonacciValue(n - 1) + fibonacciValue(n - 2);
    }

    private static int search(int[] arr, int findVal) {
        int low = 0;
        int mid;
        int high = arr.length - 1;

        int[] fibonacciArr = fibonacciArray(arr.length - 1);
        int k = fibonacciArr.length - 1;

        System.out.println("Fibonacci arr: " + Arrays.toString(fibonacciArr));

        int[] tempArr = Arrays.copyOf(arr, fibonacciArr[k]);
        for (int i = arr.length; i < tempArr.length; i++) {
            tempArr[i] = tempArr[high];
        }

        System.out.println("temp arr: " + Arrays.toString(tempArr));

        while (low <= high) {
            mid = low + fibonacciArr[k - 1] - 1;

            System.out.println("mid = " + mid);
            if (findVal > tempArr[mid]) {
                low = mid + 1;
                k = k -2;
            } else if (findVal < tempArr[mid]) {
                high = mid - 1;
                k = k - 1;
            } else {
                return Math.min(mid, high);
            }
        }

        return -1;
    }
}
