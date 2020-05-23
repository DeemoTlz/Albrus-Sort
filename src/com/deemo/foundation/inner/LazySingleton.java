package com.deemo.foundation.inner;

public class LazySingleton {
    static {
        System.out.println("我外部类加载了...");
    }

    public void print() {
        System.out.println("我是外部类！");
    }

    public static void prints() {
        System.out.println("我是外部类！");
    }

    protected static class Singleton {
        static {
            System.out.println("我内部类现在才加载...");
        }

        public void print() {
            System.out.println("我是内部类！");
        }

        public static void prints() {
            System.out.println("我是内部类！");
        }
    }

    public static void main(String[] args) {
        LazySingleton.prints();
        new LazySingleton().print();

        System.out.println(LazySingleton.Singleton.class);
        LazySingleton.Singleton.prints();
    }
}
