package com.deemo.foundation.string;

import org.testng.annotations.Test;

public class StringTest {

    @Test
    public void stringTest1() {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2); // true

        s1 = "abcdef";
        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void stringTest2() {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2); // true

        String s = "def";
        String s3 = "abcdef";
        String s4 = "abc" + "def";
        System.out.println(s3 == s4); //

        String s5 = s1 + "def";
        String s6 = s1 + s;
        System.out.println(s3 == s5); //
        System.out.println(s3 == s6); //
        System.out.println(s5 == s6); //

        String s7 = s5.intern();
        System.out.println(s3 == s7); //

        String s8 = s1.concat("def");
        System.out.println(s3 == s8);
    }

    private static class DeemoString {
        String str = new String("Deemo");
        char[] chars = {'D', 'e', 'e', 'm', 'o'};

        public void change(String str, char[] chars) {
            str = "Deemo去哪儿了呢？";
            chars[4] = '0';
        }
    }

    @Test
    public void stringTest3() {
        DeemoString deemoString = new DeemoString();
        deemoString.change(deemoString.str, deemoString.chars);

        System.out.println(deemoString.str);
        System.out.println(deemoString.chars);
    }

    @Test
    public void stringTest4() {
        String str = "01Saber02Lancer03Archer04Rider05Caster06Assassin07Berserker08Avenger09Ruler,";
        str = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");

        System.out.println(str);
    }

    @Test
    public void stringTest5() {
        String s1 = "abcdef";
        String s2 = "abc";

        String s3 = s2 + "def";
        System.out.println(s1 == s3); //

        final String s4 = s2;
        String s5 = s4 + "def";
        System.out.println(s1 == s5); //

        final String s6 = "abc";
        String s7 = s6 + "def";
        System.out.println(s1 == s7); //
    }

    @Test
    public void stringTest6() {
        long start = 0L;
        long end = 0L;
        int count = 99999;

        String str = "";

        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer(488885);

        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder(488885);

        // String Begin
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            str += i;
        }
        end = System.currentTimeMillis();
        System.out.println("String test take: " + (end - start) + " ms.");
        // String End

        // stringBuffer1 Begin
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            stringBuffer1.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer test take: " + (end - start) + " ms.");
        // stringBuffer1 End

        // stringBuffer2 Begin
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            stringBuffer2.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer with capacity test take: " + (end - start) + " ms.");
        // stringBuffer2 End

        // stringBuilder1 Begin
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            stringBuilder1.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder test take: " + (end - start) + " ms.");
        // stringBuilder1 End

        // stringBuilder2 Begin
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            stringBuilder2.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder with capacity test take: " + (end - start) + " ms.");
        // stringBuilder2 End
    }


}
