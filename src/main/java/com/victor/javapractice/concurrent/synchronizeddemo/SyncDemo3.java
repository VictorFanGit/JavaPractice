package com.victor.javapractice.concurrent.synchronizeddemo;

/**
 * synchronized 用法3：修饰多个普通方法, 锁住对象，并发调用时方法串行执行
 */
public class SyncDemo3 {

    synchronized public void display1() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("display1 count:" + i);
        }
    }

    synchronized public void display2() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("display2 count:" + i);
        }
    }

    public void display3() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("display3 count:" + i);
        }
    }

    public void display4() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("display4 count:" + i);
        }
    }

    //此处串行执行
    public static void main(String[] args) {
        SyncDemo3 syncDemo3 = new SyncDemo3();
        new Thread(() -> syncDemo3.display1()).start();
        new Thread(() -> syncDemo3.display2()).start();

    }

    //此处并行执行
/*    public static void main(String[] args) {
        SyncDemo3 syncDemo3 = new SyncDemo3();
        new Thread(() -> syncDemo3.display3()).start();
        new Thread(() -> syncDemo3.display4()).start();
    }*/

}
