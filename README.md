# JustTryHard-Sort
**Just learn Sorting Algorithm…φ(๑˃∀˂๑)♪** 

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

  
