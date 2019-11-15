package com.deemo.sort;

import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> {

    private T[] arr;

    public T[] getArr() {
        return arr;
    }

    public QuickSort() {
    }

    public QuickSort(T[] arr) {
        this.arr = arr;
    }

    public void sort() {
        sort(arr);
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        long currentTimeMillis = System.currentTimeMillis();

        // 15, 1, 55, 44, 32, 12
        quickSort(arr, 0, arr.length - 1);

        System.out.printf("共 %d个随机数，快速排序共花费 %5dms。\r\n", arr.length, (System.currentTimeMillis() - currentTimeMillis));
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

    private static <E extends Comparable<E>> void quickSort(E[] arr, int left, int right) {
        if (left >= right) {
            return ;
        }

        int low = left;
        int high = right;
        int mid = (left + right) / 2;
        E pivot = arr[mid];

        while (low < high) {
            while (arr[low].compareTo(pivot) < 0) {
                low++;
            }

            while (arr[high].compareTo(pivot) > 0) {
                high--;
            }

            if (low >= high) {
                break;
            }

            E temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[low].compareTo(pivot) == 0){
                high--;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[high].compareTo(pivot) == 0) {
                low++;
            }
        }

        // System.out.println("arr=" + Arrays.toString(arr));
        // System.out.printf("low = %d, high = %d\r\n", low, high);

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (low == high) {
            low++;
            high--;
        }

        // high == low is always true
        quickSort(arr, left, high);
        quickSort(arr, low, right);
    }

    private static void quickSort2(int[] arr, int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        //System.out.println("arr=" + Arrays.toString(arr));

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort2(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort2(arr, l, right);
        }
    }

    public static void main(String[] args) {
        int MAX_LENGTH = 10000 * 10;

        Integer[] arr1 = new Integer[MAX_LENGTH];
        int[] arr2 = new int[MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            int x = (int) (Math.random() * MAX_LENGTH);
            arr1[i] = x;
            arr2[i] = x;
        }

        /*Integer[] arr1 = {3, 5, 6, 5, 6, 3, 1, 3, 6, 3};
        int[] arr2 = {3, 5, 6, 5, 6, 3, 1, 3, 6, 3};*/

        long currentTimeMillis = System.currentTimeMillis();
        QuickSort.quickSort2(arr2, 0, arr2.length - 1);
        System.out.printf("共 %d个随机数，快速排序共花费 %5dms。\r\n", arr2.length, (System.currentTimeMillis() - currentTimeMillis));

        System.out.println("========");

        QuickSort.sort(arr1);
    }

}
