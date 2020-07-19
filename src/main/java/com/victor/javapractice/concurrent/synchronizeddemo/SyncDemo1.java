package com.victor.javapractice.concurrent.synchronizeddemo;

/**
 * synchronized 用法1：修饰static方法, 锁住整个类，即使创建多个对象进行调用，也是串行执行
 */
public class SyncDemo1 implements Runnable{
    synchronized public static void display() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("current count:" + i);
        }
    }

    @Override
    public void run() {
        SyncDemo1.display();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new SyncDemo1());
        Thread thread2 = new Thread(new SyncDemo1());
        Thread thread3 = new Thread(new SyncDemo1());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
