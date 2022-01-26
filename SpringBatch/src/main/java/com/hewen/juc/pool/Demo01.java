package com.hewen.juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2022/1/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Demo01 {
    public static void main(String[] args) {
//        Executors就是一个工具类，有三大方法
//        ExecutorService pool = Executors.newSingleThreadExecutor();//创建单个线程
        //pool-1-thread-1  OK
//        ExecutorService pool = Executors.newFixedThreadPool(5);//创建固定大小的线程池
        //pool-1-thread-5  OK
        ExecutorService pool = Executors.newCachedThreadPool();//遇强则强遇弱则弱可伸缩的。
        //pool-1-thread-10  OK
//        for (int i = 0; i < 10; i++) {
//            new Thread().start();
//        }
        //传统创建方法。
        //线程池用完，一定要关闭，就要放到finally里面
        try {
            for (int i = 0; i < 10; i++) {
                //使用了线程池之后，用线程池来创建线程
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "  OK");
                });
            }
        } finally {
            pool.shutdown();
        }
    }
}
