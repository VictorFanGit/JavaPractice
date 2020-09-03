package com.victor.javapractice.concurrent.printcontent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印1-100的数
 * 解法：利用信号量作资源访问限制，可扩展实现多个线程交替打印
 */
public class TwoThreadPrintContent3 {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(1);
    private static volatile int count = 1;

    static class A implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    semaphoreA.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count <= 100) {
                    System.out.println(Thread.currentThread().getName() + " count: " + count++);
                }
                semaphoreB.release();
                if (count > 100) {
                    System.out.println("thread A is done");
                    break;
                }
            }
        }
    }

    static class B implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    semaphoreB.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count <= 100) {
                    System.out.println(Thread.currentThread().getName() + " count: " + count++);
                }
                semaphoreA.release();
                if (count > 100) {
                    System.out.println("thread B is done");
                    break;
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new A());
        Thread threadB = new Thread(new B());
        semaphoreB.acquire();
        threadA.start();
        threadB.start();
        while (threadB.isAlive()) {
            Thread.sleep(100);
        }
        System.out.println("done");
    }

}
