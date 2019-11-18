package com.deemo.sort;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {

    private T[] arr;

    public T[] getArr() {
        return arr;
    }

    public MergeSort() {
    }

    public MergeSort(T[] arr) {
        this.arr = arr;
    }

    public void sort() {
        sort(arr);
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        long currentTimeMillis = System.currentTimeMillis();

        // 15, 1, 55, 44, 32, 12
        mergeSort(arr, 0, arr.length - 1);

        System.out.printf("共 %d个随机数，归并排序共花费 %5dms。\r\n", arr.length, (System.currentTimeMillis() - currentTimeMillis));
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

    private static <E extends Comparable<E>> void mergeSort(E[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            // System.out.printf("左：left = %d, right = %d, ", left, mid);
            // System.out.printf("右：left = %d, right = %d\n", mid + 1, right);
            // System.out.printf("left = %d, mid = %d, right = %d\n", left, mid, right);

            merge(arr, left, mid, right);
        }
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int left, int mid, int right) {
        int p1 = left, p2 = mid + 1, k = left;
        E[] temp = Arrays.copyOf(arr, arr.length);

        while (p1 <= mid && p2 <= right) {
            if (arr[p1].compareTo(arr[p2]) <= 0) {
                temp[k++] = arr[p1++];
            } else {
                temp[k++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            temp[k++] = arr[p1++];
        }

        while (p2 <= right) {
            temp[k++] = arr[p2++];
        }
        // System.out.println("temp arr = " + Arrays.toString(temp));

        if (right + 1 - left >= 0) {
            System.arraycopy(temp, left, arr, left, right + 1 - left);
        }
        // System.out.println("real arr = " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {8, 7, 6, 5, 4, 3, 2, 1};
        MergeSort.sort(arr);
    }

}
