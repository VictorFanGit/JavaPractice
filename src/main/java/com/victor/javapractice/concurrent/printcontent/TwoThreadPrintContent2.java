package com.victor.javapractice.concurrent.printcontent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印1-100的数
 * 解法：利用锁机制
 */
public class TwoThreadPrintContent2 {
    private static ReentrantLock lock = new ReentrantLock();
    private static volatile int count = 1;
    private static Condition condition = lock.newCondition();

    static class A implements Runnable {
        @Override
        public void run() {
            lock.lock();
            while (count <= 100) {
                System.out.println(Thread.currentThread().getName() + " count: " + count++);
                condition.signalAll();
                try {
                    if (count > 100) {
                        break;
                    }
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread A is done");
            lock.unlock();

        }
    }

    static class B implements Runnable {
        @Override
        public void run() {
            lock.lock();
            while (count <= 100) {
                System.out.println(Thread.currentThread().getName() + " count: " + count++);
                condition.signalAll();
                try {
                    if (count > 100) {
                        break;
                    }
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread B is done");
            lock.unlock();
    }

}

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new A());
        Thread threadB = new Thread(new B());
        threadA.start();
        threadB.start();
        while (threadB.isAlive()) {
            Thread.sleep(100);
        }
        System.out.println("done");
    }

}
