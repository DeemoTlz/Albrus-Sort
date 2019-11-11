package com.deemo.sort;

import java.util.Arrays;

public class SelectionSort<T extends Comparable<T>> {

    private T[] arr;

    public T[] getArr() {
        return arr;
    }

    public SelectionSort() {
    }

    public SelectionSort(T[] arr) {
        this.arr = arr;
    }

    public void sort() {
        sort(arr);
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        long currentTimeMillis = System.currentTimeMillis();

        // 15, 1, 55, 44, 32, 12
        long count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            E min = arr[i];
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (min.compareTo(arr[j]) > 0) {
                    count++;
                    min = arr[j];
                    minIndex = j;
                }
            }

            arr[minIndex] = arr[i];
            arr[i] = min;
        }

        System.out.printf("共 %d个随机数，选择排序共移动数据 %10d次，共花费 %5dms。\r\n", arr.length, count, (System.currentTimeMillis() - currentTimeMillis));
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

}
