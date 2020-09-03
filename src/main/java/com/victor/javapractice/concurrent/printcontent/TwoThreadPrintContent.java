package com.victor.javapractice.concurrent.printcontent;

/**
 * 两个线程交替打印1-100的数
 * 利用synchronized同步机制和wait notify机制
 */
public class TwoThreadPrintContent {
    private static Object monitor = new Object();
    private static volatile int count = 1;

    static class A implements Runnable {
        @Override
        public void run() {
            synchronized (monitor) {
                while (count <= 100) {
                    System.out.println(Thread.currentThread().getName() + " count: " + count++);
                    monitor.notify();
                    try {
                        if (count > 100) {
                            break;
                        }
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("thread A is done");
            }
        }
    }

    static class B implements Runnable {
        @Override
        public void run() {
            synchronized (monitor) {
                while (count <= 100) {
                    System.out.println(Thread.currentThread().getName() + " count: " + count++);
                    monitor.notify();
                    try {
                        if (count > 100) {
                            break;
                        }
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("thread B is done");
            }
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
