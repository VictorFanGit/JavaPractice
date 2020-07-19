package com.victor.javapractice.common;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CompareDemo {
    public static void main(String[] args) {
        String a = new String("ab");
        String b = new String("ab");
        String aa = "ab";
        String bb = "ab";
        if(a == b) {   //a b 是不同的对象  ==判断引用是否相同
            System.out.println("a == b is true");
        } else {
            System.out.println("a == b is false");
        }

        if(aa == bb) {   //aa bb是常量池中相同的对象
            System.out.println("aa == bb is true");
        } else {
            System.out.println("aa == bb id false");
        }

        if(a.equals(b)) {  //equals被重写了，比较的是内容是否相同
            System.out.println("a equals b is true");
        } else {
            System.out.println("a equals b is false");
        }

        if(aa.equals(bb)) { //equals被重写了，比较的是内容是否相同
            System.out.println("aa equals bb is true");
        } else {
            System.out.println("aa equals bb is false");
        }

        /**
         * 以下==比较会进行类型升级，升级规则：
         * 如果运算符任意一方的类型为double，则另一方会转换为double
         * 否则，如果运算符任意一方的类型为float，则另一方会转换为float
         * 否则，如果运算符任意一方的类型为long，则另一方会转换为long
         * 否则，两边都会转换为int
         */
        if(40.0 == 40) {  //true
            System.out.println("40.0 == 40 is true");
        } else {
            System.out.println("40.0 == 40 is false");
        }
    }
}
