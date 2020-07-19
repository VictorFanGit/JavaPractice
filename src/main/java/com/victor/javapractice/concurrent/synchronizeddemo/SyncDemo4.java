package com.victor.javapractice.concurrent.synchronizeddemo;

/**
 * synchronized 用法4：修饰代码块, 主要看锁住的类还是对象
 */
public class SyncDemo4 {
    //锁住对象
    public void display1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("display1 count:" + i);
            }
        }
    }

    //锁住类
    public void display2() {
        synchronized (SyncDemo4.class) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("display2 count:" + i);
            }
        }
    }


    //锁住单个对象，并行执行
    /*public static void main(String[] args) {
        SyncDemo4 instance1 = new SyncDemo4();
        SyncDemo4 instance2 = new SyncDemo4();
        SyncDemo4 instance3 = new SyncDemo4();
        new Thread(() -> {
            instance1.display1();
        }).start();
        new Thread(() -> {
            instance2.display1();
        }).start();
        new Thread(() -> {
            instance3.display1();
        }).start();
    }*/

    //锁住类，串行执行
    public static void main(String[] args) {
        SyncDemo4 instance1 = new SyncDemo4();
        SyncDemo4 instance2 = new SyncDemo4();
        SyncDemo4 instance3 = new SyncDemo4();
        new Thread(() -> {
            instance1.display2();
        }).start();
        new Thread(() -> {
            instance2.display2();
        }).start();
        new Thread(() -> {
            instance3.display2();
        }).start();
    }
}
