package com.deemo.sort;

import java.util.Arrays;

public class RadixSort<T extends Comparable<T>> {

    private T[] arr;

    public T[] getArr() {
        return arr;
    }

    public RadixSort() {
    }

    public RadixSort(T[] arr) {
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
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    count++;
                    E temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.printf("共 %d个随机数，基数排序共移动数据 %10d次，共花费 %5dms。\r\n", arr.length, count, (System.currentTimeMillis() - currentTimeMillis));
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

}
