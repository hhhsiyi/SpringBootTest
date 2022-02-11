package com.hewen.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2022/2/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class CASDemo {
    //原子类的integer
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2022);
//        AtomicStampedReference<Object> objectAtomicStampedReference = new AtomicStampedReference<>();
        atomicInteger.compareAndSet(2022, 2024);//比较并交换！期望值，更新值
        boolean b = atomicInteger.compareAndSet(2022, 2023);
        System.out.println(b);
        //如果期望的值达到了，就更新，否则就不更新
        System.out.println(atomicInteger.get());
        //CAS是CPU的并发原语！
        atomicInteger.getAndIncrement();//内存操作，效率是很高的！
//public final boolean compareAndSet(int expectedValue, int newValue) {
//        return U.compareAndSetInt(this, VALUE, expectedValue, newValue);
//    }
        //===================捣乱的线程
        atomicInteger.compareAndSet(2024, 2021);
        atomicInteger.compareAndSet(2021, 2024);
        //================期望的线程
        atomicInteger.compareAndSet(2024, 2023);
        System.out.println(atomicInteger.get());
        //对于我们平时写的SQL，就是乐观锁！
    }
}

class CASDemo2 {
    public static void main(String[] args) {
        //注意：如果泛型是包装类，要注意引用问题，
        AtomicStampedReference<Integer> reference =
                new AtomicStampedReference<>(122, 1);
        new Thread(() -> {
            int stamp = reference.getStamp();//版本号
            System.out.println("A1->" + stamp);
            //这是乐观锁的实现方式之一：版本号机制
            System.out.println(reference.compareAndSet(122, 124,
                    reference.getStamp(), reference.getStamp() + 1));
            System.out.println("A2->" + reference.getStamp());
            System.out.println(reference.compareAndSet(124, 122,
                    reference.getStamp(), reference.getStamp() + 1));
            System.out.println("A3->" + reference.getStamp());

        }, "A").start();

        new Thread(() -> {
            int stamp = reference.getStamp();//版本号
            System.out.println("B1->" + reference.getStamp());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //加版本号！
            System.out.println(reference.compareAndSet(122, 124,
                    reference.getStamp(), reference.getStamp() + 1));
            System.out.println("B2->" + reference.getStamp());
        }, "B").start();
        Lock lock = new ReentrantLock();
    }
}