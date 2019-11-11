package com.deemo.sort;

import java.util.Arrays;

public class ShellSort<T extends Comparable<T>> {
    private T[] arr;

    public T[] getArr() {
        return arr;
    }

    public ShellSort() {
    }

    public ShellSort(T[] arr) {
        this.arr = arr;
    }

    public void sort() {
        sort(arr);
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        long currentTimeMillis = System.currentTimeMillis();

        // 15, 1, 55, 44, 32, 12
        long count = 0;
        // 交换式
        /*for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j].compareTo(arr[j + gap]) > 0) {
                        E temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }*/

        // 移位式
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 一直比较到最后一个元素，故 i < arr.length（不减一）
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                E temp = arr[j];
                while (j - gap >= 0 && temp.compareTo(arr[j - gap]) < 0) {
                    count++;
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }

        System.out.printf("共 %d个随机数，希尔排序共移动数据 %10d次，共花费 %5dms。\r\n", arr.length, count, (System.currentTimeMillis() - currentTimeMillis));
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

}
