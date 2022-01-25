package com.hewen.juc.add;

import java.util.concurrent.CountDownLatch;

/**
 * 2022/1/25
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class CountDownLatchDemo {
    //计数器，减法计数器
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        //倒计时，总数是6，一般会在一些必须要执行的任务中使用！
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go Out");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//等待计数器归零，然后向下执行。
        System.out.println("关闭");
    }
}
