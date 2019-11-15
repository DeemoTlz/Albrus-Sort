package com.deemo.tlz;

import com.deemo.sort.*;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {
        int MAX_LENGTH = 10000 * 10;

        Integer[] arr1 = new Integer[MAX_LENGTH];
        Integer[] arr2 = new Integer[MAX_LENGTH];
        Integer[] arr3 = new Integer[MAX_LENGTH];
        Integer[] arr4 = new Integer[MAX_LENGTH];
        Integer[] arr5 = new Integer[MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            int x = (int) (Math.random() * MAX_LENGTH);
            arr1[i] = x;
            arr2[i] = x;
            arr3[i] = x;
            arr4[i] = x;
            arr5[i] = x;
        }

        // BubbleSort<Integer> bubbleSort = new BubbleSort<>(arr1);
        // bubbleSort.sort();
        // bubbleSort.print();

        // SelectionSort<Integer> selectionSort = new SelectionSort<>(arr2);
        // selectionSort.sort();
        // selectionSort.print();

        // InsertionSort<Integer> insertionSort = new InsertionSort<>(arr3);
        // insertionSort.sort();
        // insertionSort.print();

        ShellSort<Integer> shellSort = new ShellSort<>(arr4);
        shellSort.sort();
        // insertionSort.print();

        QuickSort<Integer> quickSort = new QuickSort<>(arr5);
        quickSort.sort();
        // insertionSort.print();

        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(Arrays.equals(arr2, arr3));
        System.out.println(Arrays.equals(arr3, arr4));
        System.out.println(Arrays.equals(arr4, arr5));

    }
}
