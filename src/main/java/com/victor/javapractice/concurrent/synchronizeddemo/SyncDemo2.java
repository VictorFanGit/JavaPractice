package com.victor.javapractice.concurrent.synchronizeddemo;

/**
 * synchronized 用法2：修饰普通方法, 锁住对象，如果创建了多个对象，每个对象的调用不影响
 */
public class SyncDemo2 implements Runnable{
    synchronized public void display(){
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
        display();
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(new SyncDemo2());
        Thread thread2 = new Thread(new SyncDemo2());
        Thread thread3 = new Thread(new SyncDemo2());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
