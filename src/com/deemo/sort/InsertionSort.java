package com.deemo.sort;

import java.util.Arrays;

public class InsertionSort<T extends Comparable<T>> {

    private T[] arr;

    public T[] getArr() {
        return arr;
    }

    public InsertionSort() {
    }

    public InsertionSort(T[] arr) {
        this.arr = arr;
    }

    public void sort() {
        sort(arr);
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        long currentTimeMillis = System.currentTimeMillis();

        // 15, 1, 55, 44, 32, 12
        long count = 0;
        for (int i = 1; i < arr.length; i++) {
            E insertVal = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && arr[insertIndex].compareTo(insertVal) > 0) {
                count++;
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            arr[insertIndex + 1] = insertVal;
        }

        System.out.printf("共 %d个随机数，插入排序共移动数据 %10d次，共花费 %5dms。\r\n", arr.length, count, (System.currentTimeMillis() - currentTimeMillis));
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

}
