# JustTryHard-Sort
## Just learn Sorting Algorithm…φ(๑˃∀˂๑)♪

- 冒泡排序

  ```java
  // 两层 for 循环，每次遍历获得一个最大/最小的数
  for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
          if (arr[j] > arr[j + 1]) {
              swap(arr[j], arr[j + 1]);
          }
      }
  }
  ```

- 选择排序

  ```java
  // 每次获取一个最大/最小的数
  
  ```

- 插入排序

  ```java
  // 初始将第一个数当做有序数组，每次遍历找到下一个数的插入位置
  
  ```

- 希尔排序

  ```java
  // 在插入排序算法上进行优化
  // 设定步长，将一个无序数组逐渐变为一个有序数组，步长初始为 length / 2
  // 当步长 = 1时，即是一个插入算法
  
  ```

- 快速排序

  ```java
  // 找一个基准数，基准数左边全是比基准数小的数，基准数右边全是比基准数大的数
  
  ```

- 归并排序

  ```java
  
  ```

- 基数排序

  ```java
  
  ```
  
- 堆排序

  ```java
  // 使用线索化二叉树遍历数组
  // 首先将数组调整为一个大、小顶堆。此时，头节点为数组中最大、小的数
  // 将头结点与树最后一个节点交换
  // 此时，树的最后 n 个数就是一个有序数组
  // 再调整前面 arr.length - n 个数为大、小顶堆
  public static <E extends Comparable<E>> void sort(E[] arr) {
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
  ```

## 树


## 迷宫


## 后缀表达式



