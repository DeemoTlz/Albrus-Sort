package com.deemo.foundation.tryFinallyReturn;

public class FinallyTest {

    public static void main(String[] args) {
        System.out.println(FinallyTest.test());
        System.out.println(FinallyTest.test2());
    }

    public static int test() {
        int x = 1;
        try {
            x++;
            return x / 2; // 2
        } finally {
            x++;
        }
    }

    private static int test2() {
        try {
            System.out.println("try...");
            int i = 1 / 0;
            // double i = 1 / 0.0;
            return 0;
        } catch (Exception e) {
            System.out.println("catch...");
            // return -1;
            throw e;
        } finally {
            /*System.out.println("finally...");
            return Integer.MAX_VALUE;*/

            // throw new RuntimeException("finally exception...");
        }

        // return -1;
    }
}
