package com.victor.javapractice.common;

/**
 * sleep不会释放对象的锁，wait会释放
 */
public class WaitAndSleep {
    public static void main(String[] args) {
        WaitAndSleep waitAndSleep = new WaitAndSleep();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (waitAndSleep) {   //此处需要锁住对象
            try {
                waitAndSleep.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
