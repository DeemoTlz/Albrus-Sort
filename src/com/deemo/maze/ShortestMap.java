package com.deemo.maze;

public class ShortestMap {

    public static void main(String[] args) {
        // m: X轴 n: Y轴
        int m = 5, n = 6;
        int[][] map = initMaze(m, n);
        map[3][2] = -1;
        map[4][2] = -1;
        map[4][3] = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%3d", map[i][j]);
            }
            System.out.println();
        }

        System.out.println(way(map, 1, 1));

    }

    private static int[][] initMaze(int m, int n) {
        int[][] maze = new int[n][m];

        // 上下
        for (int i = 0; i < m; i++) {
            maze[0][i] = -1;
            maze[n - 1][i] = -1;
        }

        // 左右
        for (int i = 0; i < n; i++) {
            maze[i][0] = -1;
            maze[i][m - 1] = -1;
        }

        return maze;
    }

    private static boolean way(int[][] map, int i, int j) {
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            if (map[i][j] == 2) {
                // 记录1的个数
                for (int[] ints : map) {
                    for (int y = 0; y < map[0].length; y++) {
                        System.out.printf("%3d", ints[y]);
                    }
                    System.out.println();
                }
                return true;
            }

            if (map[i][j] == -1) {
                return false;
            }

            if (map[i][j] == 0) {
                map[i][j] = 1;
                System.out.printf("i = %d, j = %d\r\n", i, j);
                for (int dd = 0; dd < 4; dd++) {
                    way(map, i + dx[dd], j + dy[dd]);
                }
            }
        }

        return false;
    }
}


