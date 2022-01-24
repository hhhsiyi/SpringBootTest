package com.hewen.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2022/1/24
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
// 多线程开发中，线程就是一个单独的资源类，没有任何的附属操作
//1.属性、方法；一定要降低耦合度
public class SaleTicketDemo01 {
    //并发：多个线程操作同一个资源类
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        //FunctionalInterface函数式接口，1.8之后就是lambda表达式了:(参数)->{代码}
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();
        new Thread(() -> {for (int i = 0; i < 60; i++) ticket.sale();}, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "C").start();
    }
}

class Ticket {
    private int number = 50;

    //卖票的方式
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第：" + number-- + "张票，剩余了" + number + "张票");
        }
    }
}

class Ticket2 {
    private int number = 50;
    Lock lock = new ReentrantLock();

    //卖票的方式
    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第：" + number-- + "张票，剩余了" + number + "张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}