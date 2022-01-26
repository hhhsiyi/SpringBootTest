package com.hewen.juc.bq;

import org.apache.tomcat.util.collections.SynchronizedQueue;

import java.util.concurrent.TimeUnit;

/**
 * 2022/1/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class SynchronizedQueueTest {
    public static void main(String[] args) {
        SynchronizedQueue<String> queue = new SynchronizedQueue<>();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"->>>>put1");
            queue.offer("1");
            System.out.println(Thread.currentThread().getName()+"->>>>put2");
            queue.offer("2");
            System.out.println(Thread.currentThread().getName()+"->>>>put3");
            queue.offer("3");
        },"T1").start();
        new Thread(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println(Thread.currentThread().getName()+"->>>>get  "+queue.poll());
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println(Thread.currentThread().getName()+"->>>>get  "+queue.poll());
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println(Thread.currentThread().getName()+"->>>>get  "+queue.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
