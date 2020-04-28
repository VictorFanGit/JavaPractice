package com.victor.javapractice.collection;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.checkerframework.checker.units.qual.Prefix.deci;

public class AboutList {

    protected void error(){
        String[] array= {"a","b","c"};
        //Arrays.asList返回的只是 Arrays 一个内部类，并非真正的 java.util.ArrayList
        List<String> strings = Arrays.asList(array);

        //修改时会影响原数组的数据
        strings.set(0, "modify");
        System.out.println(strings);
        System.out.println(Arrays.toString(array));

        //运行时会抛出java.lang.UnsupportedOperationException
        strings.add("d");
    }

    protected void correct() {
        String[] array= {"a","b","c"};
        //方法1：使用时套一层ArrayList
        List<String> strings1 = new ArrayList<>(Arrays.asList(array));
        //方法2：推荐使用Guava的Lists
        List<String> strings2 = Lists.newArrayList(array);
        strings2.add("d");
        System.out.println(strings2);
    }

    /**
     * 使用原生的List中的subList生成的新List也会与原始List相互影响
     */
    protected void error2() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        List<Integer> subIntegers = integers.subList(0, 2);
        subIntegers.set(0,11);
        System.out.println(integers);
        System.out.println(subIntegers);

    }

    /**
     * 使用foreach删除元素的坑
     */
    protected void error3() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));
        for (Integer integer : integers) {
            if(integer == 1) {
                //运行时抛出ConcurrentModificationException
                integers.remove(integer);
            }
        }
    }

    protected void correct3() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));
        // Iterator方式实现删除
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if(integer == 1) {
                iterator.remove();
            }
        }
        System.out.println(integers);

        //java8中的方法
        integers.removeIf(integer -> integer == 2);

        System.out.println(integers);
    }

    public static void main(String[] args) {
        AboutList aboutList = new AboutList();
//        aboutList.error();
//        aboutList.error2();
//        aboutList.error3();
        aboutList.correct();
        aboutList.correct3();
    }
}
