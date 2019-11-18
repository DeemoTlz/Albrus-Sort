package com.deemo.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(search(arr, 8, 0, arr.length - 1));
    }

    private static int search(int[] arr, int findVal, int left, int right) {
        if (left < 0 || right >= arr.length || left > right) {
            return -1;
        }

        int midIdx = (left + right) / 2;
        int midVal = arr[midIdx];
        if (findVal > midVal) {
            return search(arr, findVal, midIdx + 1, right);
        } else if (findVal < midVal) {
            return search(arr, findVal, left, midIdx - 1);
        } else {
            return midIdx;
        }
    }
}
