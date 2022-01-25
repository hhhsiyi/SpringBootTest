package com.hewen.juc.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 2022/1/25
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        MyCacheLock myCache = new MyCacheLock();
        for (int i = 1; i < 6; i++) {
            final int t = i;
            Thread.sleep(100);
            new Thread(() -> {
                //写入
                myCache.put(t+"", UUID.randomUUID().toString().substring(0,5));
//                myCache.put(t+"", t);
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i < 6; i++) {
            final int t = i;
            Thread.sleep(100);
            new Thread(()->{
                myCache.get(t+"");
            },String.valueOf(i)).start();
        }
        //啥也不做，问题很大！
        //读-读  可以共存
        //读-写  不能共存
        //写-写  不能共存
        //独占锁(写锁)、共享锁(读锁)多个线程可以同时占有
    }
}

/**
 * 自定义缓存
 */
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    //存、取
    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "写入");
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入完毕");
    }

    public Object get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取");
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完毕");
        return map.get(o);
    }
}
class MyCacheLock {
    //这个是加锁的缓存！
    private volatile Map<String, Object> map = new HashMap<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock simpleLock = new ReentrantLock();//普通非公平锁，粒度不够细
    //读写锁，就是更加细粒度的控制。
    //写入的时候，我希望只有一个线程去写，读的时候我希望大家都能去读
    //存、取
    public void put(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void get(String key) {
        //我希望所有人都能读
        //读加锁可以理解为了防止事务的脏读
        //读取加锁，是为了防止写的时候进行读
        //读锁,主要是实现读写分离,读写互斥,防止读的时候其他线程写
        lock.readLock().lock();
        Object o = new Object();
        try {
            System.out.println(Thread.currentThread().getName() + "读取");
            o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
//        return map.get(o);
    }
}