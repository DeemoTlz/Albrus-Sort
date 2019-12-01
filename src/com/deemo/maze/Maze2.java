package com.deemo.maze;

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