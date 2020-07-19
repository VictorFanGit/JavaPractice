package com.victor.javapractice.common;

public class StringToInteger {

    public static void main(String[] args) {
        //java 11 中不推荐使用，实际调用了 parseInt
        Integer val1 = new Integer("1");

        // 获取给定的字符串所代表的整数，实际调用的parseInt
        Integer val2 = Integer.valueOf("2");

        //除了解析普通数字还可解析16进制等表示，如0x10，适合用来分析数字
        Integer val3 = Integer.decode("0x10");

        // 特别注意：根据指定的名称得到系统属性的整数值,因此返回值为null
        Integer val4 = Integer.getInteger("4");

        //只能分析纯数字（String表示），不能识别16进制表示的数，比如0x40
        int val5 = Integer.parseInt("5");

        //以16进制方式解析，结果为32
        int val6 = Integer.parseInt("20",16);

        System.out.println(val1);
        System.out.println(val2);
        System.out.println(val3);
        System.out.println(val4);
        System.out.println(val5);
        System.out.println(val6);
    }
}

