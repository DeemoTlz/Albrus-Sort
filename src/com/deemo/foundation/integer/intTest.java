package com.deemo.foundation.integer;

import org.testng.annotations.Test;

public class intTest {

    @Test
    // 场景1
    public void testInstance() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); //

        i = new Integer(128);
        j = new Integer(128);
        System.out.println(i == j); //
    }

    @Test
    // 场景2
    public void testUnbox() {
        Integer i = new Integer(100);
        int j = 100;

        // 自动拆箱
        System.out.println(i == j); //

        /*i = null;
        System.out.println(i == 1);*/
    }

    @Test
    // 场景3
    public void testInstance2() {
        Integer i = new Integer(100);
        Integer j = 100; //

        System.out.println(i == j); //

        i = new Integer(128);
        j = 128;

        System.out.println(i == j); //
    }

    @Test
    // 场景4
    public void testCache() {
        // 断点查看从缓存获取
        Integer i = 1;
        Integer j = 1;
        System.out.println(i == j); //

        i = 127;
        j = 127;
        System.out.println(i == j); //

        i = 128;
        j = 128;
        System.out.println(i == j); //
    }

}
