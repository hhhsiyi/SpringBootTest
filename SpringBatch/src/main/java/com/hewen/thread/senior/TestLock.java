package com.hewen.thread.senior;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 2021/12/21
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//锁
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
//        给run加synchronized关键字，或者用lock
    }
}

class TestLock2 implements Runnable {
    int ticketNums = 100;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();//开始的时候加锁，结束的时候解锁
                //sleep没有释放锁，所以只有第一个线程在执行
                if (ticketNums > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"----"+ticketNums--);
                } else {
                    break;
                }
            }finally {
                lock.unlock();
            }

        }
    }
}
