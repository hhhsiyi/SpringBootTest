package com.hewen.juc.volatileTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2022/2/9
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class VolatileDemo2 {
//    private volatile static int num = 0;
    private volatile static AtomicInteger num = new AtomicInteger();
    public static void add(){
//        num++;
        num.getAndIncrement();//AtomicInteger的加一，不是简单的+1，调用的CAS，是CPU底层的并发，效率极高
        //synchronized可以20000,volatile不行，为啥呢，因为num++不是一个原子性的操作，我们反编译为字节码去看看
        //javap -c VolatileDemo2.class
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            },i+"").start();
        }
        //理论上我们的num应该为2w
        System.out.println(num);
        while (Thread.activeCount()>2){
            //默认的两个线程为main和gc线程
            Thread.yield();//礼让
        }
        System.out.println(Thread.currentThread().getName()+"    "+num);
    }
}
