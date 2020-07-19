package com.victor.javapractice.collection.hashmap;

import java.util.HashMap;

/**
 * 自定义class作为hashmap的key时，需要重写hash方法和equals方法
 */
public class HashMapKey {

    public static void main(String[] args) {
        HashMapKey instance = new HashMapKey();
        instance.wrong();
        instance.correct();
    }

    public void wrong(){
        HashMap<Book,String> map = new HashMap<>();
        map.put(new Book("book1"),"b1");
        map.put(new Book("book2"),"b2");
        map.put(new Book("book3"),"b3");
        map.put(new Book("book3"),"b33");  //这个记录应该覆盖掉上一个book3, 但实际没有覆盖

        System.out.println(map.toString());

        //以下返回都是null，期望应该返回正常取值
        System.out.println(map.get(new Book("book1")));
        System.out.println(map.get(new Book("book2")));
        System.out.println(map.get(new Book("book3")));
    }

    public void correct() {
        HashMap<BookWrapped,String> map = new HashMap<>();
        map.put(new BookWrapped("book1"),"b1");
        map.put(new BookWrapped("book2"),"b2");
        map.put(new BookWrapped("book3"),"b3");
        map.put(new BookWrapped("book3"),"b33");  //这个记录应该覆盖掉上一个book3, 但实际没有覆盖

        System.out.println(map.toString());

        //以下返回都是null，期望应该返回正常取值
        System.out.println(map.get(new BookWrapped("book1")));
        System.out.println(map.get(new BookWrapped("book2")));
        System.out.println(map.get(new BookWrapped("book3")));
    }

}
