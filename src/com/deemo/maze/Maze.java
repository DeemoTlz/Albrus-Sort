package com.deemo.maze;

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
