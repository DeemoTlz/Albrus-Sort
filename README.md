# JustTryHard-Sort
## Just learn Sorting Algorithm…φ(๑˃∀˂๑)♪

- 冒泡排序 - BubbleSort

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

- 选择排序 - SelectionSort

  ```java
  // 每次获取一个最大/最小的数
  // i < arr.length - 1 最后一次只剩一个数，因此循环减一
  for (int i = 0; i < arr.length - 1; i++) {
      int index = i;
      int min = arr[i];
  
      for (int j = i + 1; j < arr.length; j++) {
          if (min > arr[j]) {
              index = j;
              min = arr[j];
          }
      }
      
      arr[index] = arr[i];
      arr[i] = min;
  }
  ```

- 插入排序 - InsertionSort

  ```java
  // 初始将第一个数当做有序数组，每次遍历找到下一个数的插入位置
  for (int i = 1; i < arr.length; i++) {
      int insertIndex = i - 1;
      int insertVal = arr[i];
      
      // 后移
      while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
          arr[insertIndex + 1] = arr[insertIndex--];
      }
      
      arr[insertIndex + 1] = insertVal;
  }
  ```

- 希尔排序 - ShellSort

  ```java
  // 在插入排序算法上进行优化
  // 设定步长，将一个无序数组逐渐变为一个有序数组，步长初始为 length / 2
  // 当步长 = 1时，即是一个插入算法
  for (int gap = arr.length / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < arr.length; i++) {
          int insertIndex = i - gap;
          int insertVal = arr[i];
  
          // 后移
          while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
              arr[insertIndex + gap] = arr[insertIndex];
              insertIndex -= gap;
          }
  
          arr[insertIndex + gap] = insertVal;
      }
  }
  ```

- 快速排序 - QuickSort

  ```java
  // 找一个基准数，基准数左边全是比基准数小的数，基准数右边全是比基准数大的数
  
  ```

- 归并排序 - MergeSort

  ```java
  // 
  
  ```

- 基数排序 - RadixSort

  ```java
  // 
  
  ```
  
- 堆排序 - HeapSort

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

- 广度优先求最短路径

  ```java
  import java.util.LinkedList;
  import java.util.Queue;
  
  public class BFSMaze {
  
      private static int HEIGHT;
      private static int WIDTH;
  
      public static void main(String[] args) {
          HEIGHT = 10;
          WIDTH = 7;
          int[][] maze = initMaze(HEIGHT, WIDTH);
          maze[8][3] = 2;
          maze[3][1] = -1;
          maze[3][3] = -1;
  
          showMaze(maze);
  
          shortestWay(maze);
      }
  
      private static void shortestWay(int[][] maze) {
          int[] pathH = new int[] {1, 0, -1, 0};
          int[] pathW = new int[] {0, -1, 0, 1};
          int[][] distance = new int[HEIGHT][WIDTH];
  
          for (int i = 0; i < HEIGHT; i++) {
              for (int j = 0; j < WIDTH; j++) {
                  distance[i][j] = -1;
              }
          }
  
          Queue<Point> queue = new LinkedList<>();
          queue.offer(new Point(1, 1));
          distance[1][1] = 0;
  
          while (!queue.isEmpty()) {
              Point point = queue.poll();
  
              if (maze[point.height][point.width] == 2) {
                  System.out.println("找到了！");
                  System.out.println(distance[point.height][point.width]);
                  break;
              }
  
              for (int i = 0; i < 4; i++) {
                  int nHeight = point.height + pathH[i];
                  int nWidth = point.width + pathW[i];
  
                  // 可以走且没走过
                  if (nHeight >= 0 && nHeight < HEIGHT && nWidth >= 0 && nWidth < WIDTH && maze[nHeight][nWidth] != -1 && distance[nHeight][nWidth] == -1) {
                      queue.offer(new Point(nHeight, nWidth));
                      distance[nHeight][nWidth] = distance[point.height][point.width] + 1;
                  }
              }
          }
      }
  
      private static int[][] initMaze(int height, int width) {
          int[][] maze = new int[height][width];
  
          // 上下
          for (int i = 0; i < width; i++) {
              maze[0][i] = -1;
              maze[height - 1][i] = -1;
          }
  
          // 左右
          for (int i = 0; i < height; i++) {
              maze[i][0] = -1;
              maze[i][width - 1] = -1;
          }
  
          return maze;
      }
  
      private static void showMaze(int[][] maze) {
          for (int[] row : maze) {
              for (int x : row) {
                  System.out.printf("%3d ", x);
              }
              System.out.println();
          }
      }
  
  }
  
  class Point {
      int height;
      int width;
  
      public Point(int height, int width) {
          this.height = height;
          this.width = width;
      }
  }
  ```

- 所有解

  ```java
  // By Deemo
  public class Maze {
  
      // 横向方向
      private static final int[] dw = {-1, 0, 1, 0};
      // 纵向方向
      private static final int[] dh = {0, 1, 0, -1};
  
      public static void main(String[] args) {
          int[][] map = {
                  {-1, -1, 9, -1, -1, -1, -1, -1, -1, -1},
                  {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                  {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
                  {-1, -1, 0, -1, -1, 0, 0, 0, 0, -1},
                  {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
                  {-1, 0, 0, 0, -1, -1, -1, -1, 0, -1},
                  {-1, 0, -1, 0, -1, 0, 0, -1, 0, -1},
                  {-1, 0, -1, 0, -1, 0, -1, 0, 0, -1},
                  {-1, 0, -1, 0, 0, 0, 0, 0, 0, -1},
                  {-1, -1, -1, -1, -1, -1, -1, -1, 99, -1}
          };
  
          showMaze(map);
          escape(map, 0, 2);
      }
  
      private static void escape(int[][] map, int height, int width) {
          /*System.out.println("------------------------");
          showMaze(map);*/
  
  
          for (int direct = 0; direct < 4; direct++) {
              int nextHeight = height + dw[direct];
              int nextWidth = width + dh[direct];
  
              if (nextHeight < 0 || nextHeight >= map.length) {
                  continue;
              }
              if (nextWidth < 0 || nextWidth >= map[0].length) {
                  continue;
              }
  
              if (map[nextHeight][nextWidth] == 99) {
                  System.out.println("恭喜你啊，幸运儿~");
                  showMaze(map);
  
                  return ;
              }
  
              if (map[nextHeight][nextWidth] != -1 && map[nextHeight][nextWidth] != 1 && map[nextHeight][nextWidth] != 9) {
                  map[nextHeight][nextWidth] = 1;
                  escape(map, nextHeight, nextWidth);
                  map[nextHeight][nextWidth] = 0;
              }
          }
      }
  
      private static void showMaze(int [][] map) {
          for (int[] row : map) {
              for (int width = 0; width < map[0].length; width++) {
                  int value = row[width];
  
                  if (-1 == value) {
                      System.out.print("▒ ");
                      continue;
                  }
  
                  if (0 == value) {
                      System.out.print("• ");
                      continue;
                  }
  
                  if (1 == value) {
                      System.out.print("♥ ");
                      continue;
                  }
  
                  if (9 == value) {
                      System.out.print("♂ ");
                      continue;
                  }
  
                  if (99 == value) {
                      System.out.print("♀ ");
                  }
              }
              System.out.println();
          }
      }
  }
  
  // From net
  public class Maze2 {
      private static int LEN = 9;
      private static int WAY = 0;
  
      //构建迷宫
      private static int[][] maze = new int[][]{
              {
                      2, 0, 2, 2, 2, 0, 2, 2, 2
              },
              {
                      2, 0, 2, 2, 2, 0, 0, 2, 2
              },
              {
                      2, 0, 0, 0, 0, 0, 0, 0, 2
              },
              {
                      2, 0, 2, 2, 0, 2, 2, 0, 2
              },
              {
                      2, 0, 0, 2, 0, 2, 2, 0, 2
              },
              {
                      2, 0, 0, 2, 0, 2, 2, 0, 2
              },
              {
                      2, 0, 0, 2, 0, 0, 0, 0, 0
              },
              {
                      2, 0, 0, 0, 0, 2, 2, 2, 2
              },
              {
                      2, 0, 2, 2, 0, 2, 2, 2, 2
              }
      };
  
  
      //设置终点
      private static int end_x = 8, end_y = 4;
  
      public static void main(String[] args) {
          System.out.println("maze:");
          //打印迷宫图，为方便查看，将数字换为图形打印
          print_maze();
          //设置起点
          int start_x = 1, start_y = 0;
  
          step(start_x, start_y);
          System.out.println(WAY);
      }
  
      //用递归算法求解路径
      private static void step(int x, int y) {
          maze[x][y] = 1;
  
          if (x == end_x && y == end_y) {
              //打印函数放入递归中，每找到一条成功路径打印一次
              WAY++;
              print_maze();
              maze[x][y] = 0;
              return ;
          }
  
          if (y < (LEN - 1) && maze[x][y + 1] == 0) {
              //System.out.printf("右：(%d, %d)\r\n", x, y + 1);
              step(x, y + 1);
          }
          if (x < (LEN - 1) && maze[x + 1][y] == 0) {
              //System.out.printf("下：(%d, %d)\n", x + 1, y);
              step(x + 1, y);
          }
          if (y > 0 && maze[x][y - 1] == 0) {
              //System.out.printf("左：(%d, %d)\n", x, y - 1);
              step(x, y - 1);
          }
          if (x > 0 && maze[x - 1][y] == 0) {
              //System.out.printf("上：(%d, %d)\n", x - 1, y);
              step(x - 1, y);
          }
  
          //System.out.printf("死胡同：(%d, %d)\n", x, y);
          // 回溯关键
          maze[x][y] = 0;
      }
  
      private static void print_maze() {
          for (int x = 0; x < LEN; x++) {
              for (int y = 0; y < LEN; y++) {
                  if (maze[x][y] == 2)
                      System.out.print("#");
                  else if (maze[x][y] == 1)
                      System.out.print("X");
                  else if (maze[x][y] == 0)
                      System.out.print(".");
              }
              System.out.println();
          }
          System.out.println();
      }
  
  }
  ```

## 后缀表达式





