package com.victor.javapractice.java8;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class StreamDemo {

    @Test
    public void testRange() {
        //演示IntStream和DoubleStream
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.range(0, 3).mapToObj(i -> "x").forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }

    @Test
    public void testFlatMap() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        Collections.synchronizedMap(hashMap);
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        boolean ret = lock.tryLock();
        System.out.println("lock:" + ret);
        lock.unlock();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    }


}
