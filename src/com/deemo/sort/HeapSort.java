package com.deemo.sort;

import java.util.Arrays;

public class HeapSort<T extends Comparable<T>> {
	private T[] arr;

	public T[] getArr() {
		return arr;
	}

	public HeapSort() {
	}

	public HeapSort(T[] arr) {
		this.arr = arr;
	}

	public void sort() {
		sort(arr);
	}

	public static <E extends Comparable<E>> void sort(E[] arr) {
		long currentTimeMillis = System.currentTimeMillis();

		// 15, 1, 55, 44, 32, 12
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustToHeap(arr, i, arr.length);
		}

		for (int i = arr.length - 1; i > 0; i--) {
			E temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			adjustToHeap(arr, 0, i);
		}

		System.out.printf("共 %d个随机数，堆排序共花费 %5dms。\r\n", arr.length, (System.currentTimeMillis() - currentTimeMillis));
	}

	private static <E extends Comparable<E>> void adjustToHeap(E[] arr, int i, int length) {
		// 将以第 i 个元素为头节点的树变为 大/小顶堆
		E temp = arr[i];
		for (int k = (i << 1) + 1; k < length; k = (k << 1) + 1) {
			// k 为 i 的 左子节点
			// k + 1 即为 i 的 右子节点
			if (k + 1 < length && arr[k].compareTo(arr[k + 1]) < 0) {
				k++;
			}

			// 子节点的值比父节点大
			if (arr[k].compareTo(temp) > 0) {
				arr[i] = arr[k];
				// 继续循环处理，修改子节点所在的树
				i = k;
			} else {
				break;
			}
		}

		// 将临时值放回树
		arr[i] = temp;
	}

	public void print() {
		System.out.println(Arrays.toString(arr));
	}

}
