package com.hewen.juc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2022/1/24
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class C {
    public static void main(String[] args) {
        Data3 data = new Data3();
        //要求：a执行完调用b，b执行完调用c，c执行完调用a。
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        },"C").start();
    }
}
class Data3 {
    //资源类
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int num = 1;//1A2B3C
    public void printA(){
        lock.lock();
        try {
            //判断是否等待、业务代码执行、通知
            while (num!=1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"->>>A");
            //跟之前不一样，现在是要唤醒指定的线程！
            num=2;
            //1执行完了，我想要去唤醒2！
            condition2.signal();
            //如果用notify是不是可以   Object a,b,c;  a.notify();b.notify();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            while (num!=2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"->>>B");
            num=3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            while (num!=3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"->>>C");
            num=1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //这个在哪里用呢，生产线！
    //下单-》支付-》交易-》物流
}