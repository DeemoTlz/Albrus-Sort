package com.deemo.maze;

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
