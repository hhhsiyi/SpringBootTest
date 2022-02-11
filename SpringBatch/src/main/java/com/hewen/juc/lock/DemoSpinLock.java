package com.hewen.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 2022/2/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class DemoSpinLock {
    //自己写一个自旋锁！
    //int 0   Thread null
    //原子引用
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    //加锁
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "   ->>>myLock");
        while (!atomicReference.compareAndSet(null, thread)) {
//            自旋锁
        };
    }
    //解锁
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "   ->>>myUnLock");
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) {
        //测试自旋锁
        DemoSpinLock demoSpinLock = new DemoSpinLock();
        new Thread(()->{
            demoSpinLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                demoSpinLock.myUnLock();
            }
        },"t1").start();
        new Thread(()->{
            demoSpinLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                demoSpinLock.myUnLock();
            }
        },"t2").start();
        //只有t1解锁之后，t2才有可能拿到锁，然后把他解锁。在此期间t2在自旋
        //应该是T1获得琐，T2自旋一直尝试获得。T1解锁后，T2才可以获得琐结束自旋，然后解锁
    }
}
