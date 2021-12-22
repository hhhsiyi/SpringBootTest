package com.hewen.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2021/12/22
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestPool {
    public static void main(String[] args) {
        //1.创建线程池（线程池大小）
        ExecutorService service = Executors.newFixedThreadPool(10);
        //2.
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        service.shutdownNow();
    }
}
class MyThread implements Runnable{

    @Override
    public void run() {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Thread.currentThread().getName()+" "+i);
//        }
        System.out.println(Thread.currentThread().getName());
    }
}